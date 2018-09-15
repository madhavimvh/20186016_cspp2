import java.util.Scanner;
import java.util.Arrays;
class Quiz {
	private String[] question1;
	private String[] question2;
	private String[] question3;
	private String[] question4;
	public Quiz() {
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
	}
	public Quiz(String[] question1, String[] question2, String[] question3, String[] question4) {
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
	}
	public String[] getquestion1() {
		return question1;
	}
	public String[] getquestion2() {
		return question2;
	}

	public String[] getquestion3() {
		return question3;
	}

	public String[] getquestion4() {
		return question4;
	}
	public String toString() {
		return question1[0];
	}
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s,final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class.
        String[] question1 = new String[20];
        question1 = s.nextLine().split(":");
        String[] question2 = s.nextLine().split(":");
        String[] question3 = s.nextLine().split(":");
        String[] question4 = s.nextLine().split(":");
        new Quiz(question1, question2, question3, question4);
		System.out.println("4 are added to the quiz");
		System.out.println(quiz.getquestion1());

    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        String[] a = quiz.getquestion1();
        System.out.println(a[0] + "(1)");
        System.out.println(a[1] + " " + a[2] + " " + a[3] + " " + a[4]);
        
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
    }
}
