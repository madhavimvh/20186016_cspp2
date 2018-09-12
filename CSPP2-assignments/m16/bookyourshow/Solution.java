import java.util.Scanner;
import java.util.Arrays;
class Show {
    private String movieName;
    private String datetime;
    private String[] seats;
    public Show() {
    }
    public Show(String movieName, String datetime, String[] seats) {
        this.movieName = movieName;
        this.datetime = datetime;
        this.seats = seats;
    }
    public String getmovieName() {
        return this.movieName;
    }
    public String getdatetime() {
        return this.datetime;
    }
    public String[] getseats() {
        return this.seats;
    }

}
class Patron {
    private String patronName;
    private String mobileNumber;
    private String[] bookedSeats;
    public Patron() {
    }
    public Patron(String patronName, String mobileNumber, String[] bookedSeats) {
        this.patronName = patronName;
        this.mobileNumber = mobileNumber;
        this.bookedSeats = bookedSeats;
    }
    public String getpatronName() {
        return patronName;
    }
    public String getmobileNumber() {
        return mobileNumber;
    }
    public String[] getbookedSeats() {
        return bookedSeats;
    }
    
}
class BookYourShow {
    private Show[] shows;
    private Patron[] patrons;
    private int showSize;
    private int patronSize;
    public BookYourShow() {
        this.shows = new Show[10];
        this.patrons = new Patron[20];
        this.showSize = showSize;
        this.patronSize = patronSize;
    }
    public void resize() {
        shows = Arrays.copyOf(shows, shows.length);
        patrons = Arrays.copyOf(patrons, patrons.length);
    }
    public void addAShow(Show newshow) {
        if (showSize == shows.length) {
            resize();
        }
        shows[showSize++] = newshow;
    }
    public void addAPatron(Patron p) {
        if (patronSize == patrons.length) {
            resize();
        }
        patrons[patronSize++] = p;
    }
    public Show getAShow(String movieName, String datetime) {
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getmovieName().equals(movieName) && shows[i].getdatetime().equals(datetime)) {
                return shows[i];
            }
        }
        return null;
        }
    public boolean checkSeats(Show show, String[] custseats) {
        int x;
        int count = 0;
        String[] seats = show.getseats();
        for (int i  = 0; i < seats.length; i++) {
                for (int j = 0; j < custseats.length; j++) {
                    if (seats[i].equals(custseats[j])) {
                        count += 0;
                        seats[i].replace(seats[i], "n/a");

                    }
                }
            }
            if (count == custseats.length) {
                return true;
            } else {
                return false;
            }
}
    public void bookAShow(String movieName, String datetime, Patron p) {
        addAPatron(p);
        Show showispresent = getAShow(movieName, datetime);
        if (showispresent != null) {
            if (checkSeats(showispresent, p.getbookedSeats())) {
                System.out.println(p.getmobileNumber() + " " + movieName + " " + datetime);

            }         
            } else {
                System.out.println("No show");
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
                    System.out.println(tokens.length);
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
                       System.out.println(show);
                    } else {
                        System.out.println("No show");
                    }
                break;

                // case "print":
                //     bys.printTicket(check[1], tokens[1], tokens[2]);
                // break;

                // case "showAll":
                //     bys.showAll();
                // break;
                default:
                break;
            }
        }
    }
}
