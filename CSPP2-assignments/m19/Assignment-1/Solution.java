import java.util.Scanner;
/**
* Class Quiz
*/
class Quiz {
    /**
     * Quiz contructor.
     */
    Quiz() {

    }
}

/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
    * Constructs the object.
    */

    /**
     * {final int 5 declaration}.
     */
    public static final int FIVE = 5;
    /**
     * {final int 4 declaration}.
     */
    public static final int FOUR = 4;
    /**
     * {final int 3 declaration}.
     */
    public static final int THREE = 3;
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
    public static void loadQuestions(final Scanner s, final Quiz quiz,
     final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class

        // for (int i = 0; i < questionscount; i++) {
        //  String[] question = s.nextLine();
        //  String[][] choice = s.nextLine();
        // System.out.println(questionscount + " are added to the quiz");
        // }
        if (questionCount == 0) {
            System.out.println("Quiz does not have questions");
            return;
        }
        String a = s.nextLine();
        String[] error = a.split(":");
        String[] errorPoint = error[1].split(",");
        int number = Integer.parseInt(error[2]);
        if (error[0] == null || error.length < FIVE || error[0].length() == 0) {
            System.out.println("Error! Malformed question");
            return;
        }
        int penalityError = Integer.parseInt(error[FOUR]);
        if (penalityError > 0) {
            System.out.println("Invalid penalty for " + error[0]);
            return;
        }
        int scoreError = Integer.parseInt(error[THREE]);
        if (scoreError < 0) {
            System.out.println("Invalid max marks for " + error[0]);
            return;
        }
        if (errorPoint.length < FOUR) {
            System.out.println(error[0] +
                " does not have enough answer choices");
            return;
        }
        if (number > FOUR) {
            System.out.
            println("Error! Correct answer choice number is out of range for question text 1");
            return;
        }

        System.out.println(questionCount + " are added to the quiz");
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz,
     final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object

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