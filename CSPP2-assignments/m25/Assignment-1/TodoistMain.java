import java.util.Scanner;
import java.util.Arrays;
// import java.lang.Boolean;
/**
  * write your code below this comment.
  */
class Task {
    /**
     * { var_description }.
     */
    private String title;
    /**
     * { var_description }.
     */
    private String assignedTo;
    /**
     * { var_description }.
     */
    private int timeToComplete;
    /**
     * { var_description }.
     */
    private boolean important;
    /**
     * { var_description }.
     */
    private boolean urgent;
    /**
     * { var_description }.
     */
    private String status;
    Task() {
    }
    /**
     * Constructs the object.
     *
     * @param      titlee           The titlee
     * @param      assignedToo      The assigned too
     * @param      timeToCompletee  The time to completee
     * @param      importantt       The importantt
     * @param      urgentt          The urgentt
     * @param      statuss          The statuss
     * @param      Exception        The exception
     */
    Task(final String titlee, final String assignedToo,
        final int timeToCompletee, final boolean importantt,
        final boolean urgentt, final String statuss) throws Exception {
            title = titlee;
        if (titlee.length() > 0) {
            this.title = titlee;
        } else {
            throw new Exception("Title not provided");
        }
        this.assignedTo = assignedToo;
            timeToComplete = timeToCompletee;
        if (timeToCompletee > 0) {
            this.timeToComplete = timeToCompletee;
        } else {
            throw new Exception("Invalid timeToComplete " + timeToComplete);
        }
        this.important = importantt;
        this.urgent = urgentt;
            status = statuss;
        if (statuss.equals("todo") || statuss.equals("done")) {
            this.status = statuss;
        } else {
            throw new Exception("Invalid status " + status);
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String impval = "";
        String urgval = "";
        if (important) {
            impval = "Important";
        } else {
            impval = "Not Important";
        }
        if (urgent) {
            urgval = "Urgent";
        } else {
            urgval = "Not Urgent";
        }
        return title + ", " + assignedTo + ", "
        + timeToComplete + ", " + impval + ", "
        + urgval + ", " + status;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String gettitle() {
        return title;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getassignedTo() {
        return assignedTo;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int gettimetocomplete() {
        return timeToComplete;
    }
    /**
     * Gets the important.
     *
     * @return     The important.
     */
    public String getImportant() {
        String impval = "";
        if (important) {
            impval = "Important";
        } else {
            impval = "Not Important";
        }
        return impval;
    }
    /**
     * Gets the urgent.
     *
     * @return     The urgent.
     */
    public String getUrgent() {
        String urgval = "";
        if (urgent) {
            urgval = "Urgent";
        } else {
            urgval = "Not Urgent";
        }
        return urgval;
    }
    /**
     * Gets the status.
     *
     * @return     The status.
     */
    public String getStatus() {
        return status;
    }
}
/**
 * Class for todoist.
 */
class Todoist {
    /**
     * { var_description }.
     */
    private static final int TEN = 10;
    /**
     * { var_description }.
     */
    private Task[] taskarr;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Todoist() {
        taskarr = new Task[TEN];
        size = 0;
    }
    /**
     * { function_description }.
     */
    public void resize() {
        taskarr = Arrays.copyOf(taskarr, 2 * taskarr.length);
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * Adds a task.
     *
     * @param      task  The task
     */
    public void addTask(final Task task) {
        if (size == taskarr.length) {
            resize();
        }
        taskarr[size++] = task;
    }
    /**
     * Gets the next task.
     *
     * @param      pername  The pername
     *
     * @return     The next task.
     */
    public Task getNextTask(final String pername) {
        for (int i = 0; i < size; i++) {
            if (taskarr[i].getassignedTo().equals(pername)) {
                if (taskarr[i].getStatus().equals("todo")
                    && taskarr[i].getImportant().equals("Important")
                    && taskarr[i].getUrgent().equals("Not Urgent")) {
                    return taskarr[i];
                }
            }
        }
        return null;
    }
    /**
     * Gets the next task.
     *
     * @param      pername  The pername
     * @param      coutas   The coutas
     *
     * @return     The next task.
     */
    public Task[] getNextTask(final String pername, final Integer coutas) {
        Task[] task1 = new Task[coutas];
        int size1 = 0;
        for (int i = 0; i < size; i++) {
            if (taskarr[i].getassignedTo().equals(pername)) {
                if (taskarr[i].getStatus().equals("todo")
                    && taskarr[i].getImportant().equals("Important")
                    && taskarr[i].getUrgent().equals("Not Urgent")) {
                    task1[size1] = taskarr[i];
                    size1++;
                    if (size1 == coutas) {
                        break;
                    }
                }
            }
        }
        return task1;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int totalTime4Completion() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (taskarr[i].getStatus().equals("todo")) {
                total += taskarr[i].gettimetocomplete();
            }
        }
        return total;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += taskarr[i].gettitle() + ", " + taskarr[i].getassignedTo()
            + ", " + taskarr[i].gettimetocomplete()
            + ", " + taskarr[i].getImportant() + ", " + taskarr[i].getUrgent()
            + ", " + taskarr[i].getStatus() + "\n";
        }
        return s;
    }
}
/**
 * Class for todoist main.
 */
class TodoistMain {
    /**
     * { var_description }.
     */
    private static final int THR = 3;
    /**
     * { var_description }.
     */
    private static final int FOU = 4;
    /**
     * { var_description }.
     */
    private static final int FIV = 5;
    /**
     * { var_description }.
     */
    private static final int SIX = 6;
    /**
     * Starts a test.
     */
    
    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                try {
                    testTask(tokens);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[THR]);
        boolean important = tokens[FOU].equals("y");
        boolean urgent = tokens[FIV].equals("y");
        String status = tokens[SIX];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
