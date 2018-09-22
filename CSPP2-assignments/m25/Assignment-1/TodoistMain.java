import java.util.Scanner;
import java.util.Arrays;
import java.lang.Boolean;

/**
  * write your code below this comment
  */
class Task {
	private String title;
	private String assignedTo;
	private int timeToComplete;
	private boolean important;
	private boolean urgent;
	private String status;
	public Task() {
	}
	public Task(String titlee, String assignedToo, int timeToCompletee, boolean importantt, boolean urgentt, String statuss) throws Exception {
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
		return title + ", " + assignedTo + ", " + timeToComplete + ", " + impval + ", " + urgval + ", " + status;
	}
	public String gettitle() {
		return title;
	}
	public String getassignedTo() {
		return assignedTo;
	}
	public int gettimetocomplete() {
		return timeToComplete;
	}
	public String getImportant() {
		String impval = "";
		if (important) {
			impval = "Important";
		} else {
			impval = "Not Important";
		}
		return impval;
	}
	public String getUrgent() {
		String urgval = "";
		if (urgent) {
			urgval = "Urgent";
		} else {
			urgval = "Not Urgent";
		}
		return urgval;
	}
	public String getStatus() {
		return status;
	}
}
class Todoist {
	private static final int TEN = 10;
	private Task[] taskarr;
	private int size;
	public Todoist() {
		taskarr = new Task[TEN];
		size = 0;
	}
	public void resize() {
		taskarr = Arrays.copyOf(taskarr, 2 * taskarr.length);
	}
	public int size() {
		return size;
	}
	public void addTask(Task task) {
		if (size == taskarr.length) {
			resize();
		}
		taskarr[size++] = task;
	}
	public Task getNextTask(String pername) {
		for (int i = 0; i < size; i++) {
			if (taskarr[i].getassignedTo().equals(pername)) {
				if (taskarr[i].getStatus().equals("todo") && taskarr[i].getImportant().equals("Important") && taskarr[i].getUrgent().equals("Not Urgent")) {
					return taskarr[i];
				}
			}
		}
		return null;
	}
	public Task[] getNextTask(String pername, Integer coutas) {
		Task[] task1 = new Task[coutas];
		int size1 = 0;
		for (int i = 0; i < size; i++) {
			if (taskarr[i].getassignedTo().equals(pername)) {
				if (taskarr[i].getStatus().equals("todo") && taskarr[i].getImportant().equals("Important") && taskarr[i].getUrgent().equals("Not Urgent")) {
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
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += taskarr[i].gettitle() + ", " + taskarr[i].getassignedTo() + ", " + taskarr[i].gettimetocomplete()
			+ ", " + taskarr[i].getImportant() + ", " + taskarr[i].getUrgent()
			+ ", " + taskarr[i].getStatus() + "\n";
			
		}
		return s;
	}

}
/**
 * Class for todoist main.
 */
public class TodoistMain {

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
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
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
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
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
