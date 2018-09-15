import java.util.Scanner;
/**
 * Class for quiz.
 */
class Quiz {
/**
 *
 */
    private int quiz;
/**
 *
 */
    private String questiontxt;
/**
 *
 */
    private int maxmark;
/**
 *
 */
    private int choice;
/**
 *
 */
    Quiz() {
    }
    /**
     * Constructs the object.
     *
     * @param      quizz         The quizz
     * @param      questiontxtt  The questiontxtt
     * @param      maxmarkk      The maxmarkk
     * @param      choicee       The choicee
     */
    Quiz(final int quizz, final String questiontxtt, final int maxmarkk,
         final int choicee) {
        this.quiz = quizz;
        this.questiontxt = questiontxtt;
        this.maxmark = maxmarkk;
        this.choice = choicee;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getquiz() {
        return quiz;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getquestiontxt() {
        return questiontxt;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getmaxmark() {
        return maxmark;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getchoice() {
        return choice;
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
    public static void loadQuestions(final Scanner s, final Quiz quiz,
                                         final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class

        if (questionCount == 0) {
            System.out.println("Quiz does not have questions");
        } else {
            System.out.println(questionCount + " are added to the quiz");
        }
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
        //for (int i = 1; i <= answerCount; i++) {
            //System.out.println("question text " + quiz + "(" + s + ")");
        //}
    }
    /**.
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
    }
}