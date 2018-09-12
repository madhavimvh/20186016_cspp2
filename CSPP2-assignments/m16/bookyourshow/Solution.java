import java.util.Scanner;
import java.util.Arrays;
/**
 * { item_description }.
 */
final class Show {
    /**
     * { var_description }.
     */
    private String movieName;
    /**
     * { var_description }.
     */
    private String datetime;
    /**
     * { var_description }.
     */
    private String[] seats;
    /**
     * Constructs the object.
     */
    protected Show() {
    }
    /**
     * Constructs the object.
     *
     * @param      movieNamee  The movie name
     * @param      datetimee   The datetime
     * @param      seatss      The seats
     */
    protected Show(final String movieNamee,
        final String datetimee, final String[] seatss) {
        this.movieName = movieNamee;
        this.datetime = datetimee;
        this.seats = seatss;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getmovieName() {
        return this.movieName;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getdatetime() {
        return this.datetime;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String[] getseats() {
        return this.seats;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String printexceptTickets() {
        return movieName + "," + datetime;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return movieName + "," + datetime + ","
        + Arrays.toString(seats).replace(", ", ",");
    }

}
/**
 * Class for patron.
 */
class Patron {
    /**
     * { var_description }.
     */
    private String patronName;
    /**
     * { var_description }.
     */
    private String mobileNumber;
    /**
     * { var_description }.
     */
    private String[] bookedSeats;
    /**
     * Constructs the object.
     */
    protected Patron() {
    }
    /**
     * Constructs the object.
     *
     * @param      patronNamee    The patron name
     * @param      mobileNumberr  The mobile number
     * @param      bookedSeatss   The booked seats
     */
    protected Patron(final String patronNamee, final String mobileNumberr,
        final String[] bookedSeatss) {
        this.patronName = patronNamee;
        this.mobileNumber = mobileNumberr;
        this.bookedSeats = bookedSeatss;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public String getpatronName() {
        return patronName;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getmobileNumber() {
        return mobileNumber;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String[] getbookedSeats() {
        return bookedSeats;
    }
}
/**
 * Class for book your show.
 */
class BookYourShow {
    /**
     * { var_description }.
     */
    private static final int TEN = 10;
    /**
     * { var_description }.
     */
    private static final int TWEN = 20;
    /**
     * { var_description }.
     */
    private Show[] shows;
    /**
     * { var_description }.
     */
    private Patron[] patrons;
    /**
     * { var_description }.
     */
    private int showSize;
    /**
     * { var_description }.
     */
    private int patronSize;
    /**
     * Constructs the object.
     */
    protected BookYourShow() {
        this.shows = new Show[TEN];
        this.patrons = new Patron[TWEN];
        this.showSize = showSize;
        this.patronSize = patronSize;
    }
    /**
     * { function_description }.
     */
    public void resize() {
        shows = Arrays.copyOf(shows, shows.length);
        patrons = Arrays.copyOf(patrons, patrons.length);
    }
    /**
     * Adds a show.
     *
     * @param      newshow  The newshow
     */
    public void addAShow(final Show newshow) {
        if (showSize == shows.length) {
            resize();
        }
        shows[showSize++] = newshow;
    }
    /**
     * Adds a patron.
     *
     * @param      p     { parameter_description }
     */
    public void addAPatron(final Patron p) {
        if (patronSize == patrons.length) {
            resize();
        }
        patrons[patronSize++] = p;
    }
    /**
     * Gets a show.
     *
     * @param      movieName  The movie name
     * @param      datetime   The datetime
     *
     * @return     A show.
     */
    public Show getAShow(final String movieName, final String datetime) {
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getmovieName().equals(movieName)
                && shows[i].getdatetime().equals(datetime)) {
                return shows[i];
            }
        }
        return null;
    }
    /**
     * { function_description }.
     *
     * @param      show       The show
     * @param      custseats  The custseats
     *
     * @return     { description_of_the_return_value }
     */
    public boolean checkSeats(final Show show, final String[] custseats) {
        int x;
        int count = 0;
        String[] seats = show.getseats();
        for (int i  = 0; i < seats.length; i++) {
            for (int j = 0; j < custseats.length; j++) {
                if (seats[i].equals(custseats[j])) {
                    count += 1;
                    seats[i] = seats[i].replace(seats[i], "N/A");

                }
            }
        }
        return (count == custseats.length);
    }
    /**
     * { function_description }.
     *
     * @param      movieName  The movie name
     * @param      datetime   The datetime
     * @param      p          { parameter_description }
     */
    public void bookAShow(final String movieName, final String datetime,
        final Patron p) {
        addAPatron(p);
        Show showispresent = getAShow(movieName, datetime);
        if (showispresent != null) {
            checkSeats(showispresent, p.getbookedSeats());
        } else {
            System.out.println("No show");
        }
    }
    /**
     * { function_description }.
     *
     * @param      movieName     The movie name
     * @param      datetime      The datetime
     * @param      mobileNumber  The mobile number
     */
    public void printTicket(final String movieName, final String datetime,
        final String mobileNumber) {
        Show show = getAShow(movieName, datetime);
        if (show != null) {
            for (int i = 0; i < patronSize; i++) {
                if (patrons[i].getmobileNumber().equals(mobileNumber)) {
                    System.out.println(mobileNumber + " " + movieName
                        + " " + datetime);
                    return;
                }
            }
        }
        System.out.println("Invalid");
    }
    /**
     * Shows all.
     */
    public void showAll() {
        for (int i = 0; i < showSize; i++) {
            System.out.println(shows[i]);
        }
    }

}
    // public void getAShow()

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
            replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                int k = 2;
                String[] seats = new String[tokens.length - 2];
                    // System.out.println(tokens.length);
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.addAShow(new Show(check[1], tokens[1], seats));
                break;
                case "book":
                k = 2 + 2;
                seats = new String[tokens.length - 2 - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.bookAShow(check[1], tokens[1],
                    new Patron(tokens[2], tokens[2 + 1], seats));
                break;

                case "get":
                Show show = bys.getAShow(check[1], tokens[1]);
                if (show != null) {
                   System.out.println(show.printexceptTickets());
               } else {
                System.out.println("No show");
            }
            break;
            case "print":
            bys.printTicket(check[1], tokens[1], tokens[2]);
            break;

            case "showAll":
            bys.showAll();
            break;
            default:
            break;
        }
    }
}
}
