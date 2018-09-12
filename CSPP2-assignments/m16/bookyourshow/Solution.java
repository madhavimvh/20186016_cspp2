import java.util.Scanner;
import java.util.Arrays;
class Show {
    /**
     * { var_description }
     */
    private String movieName;
    /**
     * { var_description }
     */
    private String datetime;
    /**
     * { var_description }
     */
    private String[] seats;
    /**
     * Constructs the object.
     */
    public Show() {
    }
    /**
     * Constructs the object.
     *
     * @param      movieName  The movie name
     * @param      datetime   The datetime
     * @param      seats      The seats
     */
    public Show(String movieName, String datetime, String[] seats) {
        this.movieName = movieName;
        this.datetime = datetime;
        this.seats = seats;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getmovieName() {
        return this.movieName;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getdatetime() {
        return this.datetime;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String[] getseats() {
        return this.seats;
    }
    /**
     * { function_description }
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
        return movieName + "," + datetime + "," + Arrays.toString(seats).replace(", ", ",");
    }

}
/**
 * Class for patron.
 */
class Patron {
    /**
     * { var_description }
     */
    private String patronName;
    /**
     * { var_description }
     */
    private String mobileNumber;
    /**
     * { var_description }
     */
    private String[] bookedSeats;
    /**
     * Constructs the object.
     */
    public Patron() {
    }
    /**
     * Constructs the object.
     *
     * @param      patronName    The patron name
     * @param      mobileNumber  The mobile number
     * @param      bookedSeats   The booked seats
     */
    public Patron(String patronName, String mobileNumber, String[] bookedSeats) {
        this.patronName = patronName;
        this.mobileNumber = mobileNumber;
        this.bookedSeats = bookedSeats;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getpatronName() {
        return patronName;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getmobileNumber() {
        return mobileNumber;
    }
    /**
     * { function_description }
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
     * { var_description }
     */
    private Show[] shows;
    /**
     * { var_description }
     */
    private Patron[] patrons;
    /**
     * { var_description }
     */
    private int showSize;
    /**
     * { var_description }
     */
    private int patronSize;

    /**
     * Constructs the object.
     */
    public BookYourShow() {
        this.shows = new Show[2];
        this.patrons = new Patron[2];
        this.showSize = showSize;
        this.patronSize = patronSize;
    }
    /**
     * { function_description }
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
    public void addAShow(Show newshow) {
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
    public void addAPatron(Patron p) {
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
    public Show getAShow(String movieName, String datetime) {
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getmovieName().equals(movieName) && shows[i].getdatetime().equals(datetime)) {
                return shows[i];
            }
        }
        return null;
    }
    /**
     * { function_description }
     *
     * @param      show       The show
     * @param      custseats  The custseats
     *
     * @return     { description_of_the_return_value }
     */
    public boolean checkSeats(Show show, String[] custseats) {
        int x;
        int count = 0;
        String[] seats = show.getseats();
        for (int i  = 0; i < seats.length; i++) {
            for (int j = 0; j < custseats.length; j++) {
                if (seats[i].equals(custseats[j]) ) {
                    count += 1;
                    seats[i] = seats[i].replace(seats[i], "N/A");

                }
            }
        }
        return (count == custseats.length) ;
    }
    /**
     * { function_description }
     *
     * @param      movieName  The movie name
     * @param      datetime   The datetime
     * @param      p          { parameter_description }
     */
    public void bookAShow(String movieName, String datetime, Patron p) {
        addAPatron(p);
        Show showispresent = getAShow(movieName, datetime);
        if (showispresent != null) {
            checkSeats(showispresent, p.getbookedSeats());
        } else {
            System.out.println("No show");
        }
    }
    /**
     * { function_description }
     *
     * @param      movieName     The movie name
     * @param      datetime      The datetime
     * @param      mobileNumber  The mobile number
     */
    public void printTicket(String movieName, String datetime, String mobileNumber) {
        Show show = getAShow(movieName, datetime);
        if (show != null) {
            for (int i = 0; i < patronSize; i++) {
                if (patrons[i].getmobileNumber().equals(mobileNumber)) {
                    System.out.println(mobileNumber + " " + movieName + " " + datetime);
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
