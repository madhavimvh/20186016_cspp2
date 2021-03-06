import java.util.Scanner;
// import java.util.Arrays;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
        final int correctAnswer1, final int maxMarks1, final int penalty1) {
        this.questiontext = question1;
        this.choices = choices1;
        this.correctAnswer = correctAnswer1;
        this.maxMarks = maxMarks1;
        this.penalty = penalty1;

    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
        // System.out.println(correctAnswer);
        // System.out.println("ds" + choice);
        return choice.equals(choices[correctAnswer - 1]);
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        // s = questiontext + "(" + maxMarks + ")" + "\n";
        // for (int i = 0; i < choices.length - 1; i++) {
        //  s += choices[i] + "\t";
        //  }
        // s += choices[choices.length - 1];
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        size = 0;
        questions = new Question[onehundred];
    }
    /**
     * Adds a question.
     *
     * @return     { description_of_the_return_value }.
     */
    public int size() {
        return size;
    }
    /**
     * Adds a question.
     *
     * @param      q     The quarter
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        return s;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * { var_description }.
     */
    private static final int FIVE = 5;
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
                try {
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
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
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     * @throws     Exception  { exception_description }
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) throws Exception {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
            int temp = q;
            if (q == 0) {
                System.out.println("Quiz does not have questions");
                return;
            }
            // while (q > 0)
            for (int i = 0; i < q; i++) {
                String[] tokens = scan.nextLine().split(":");
                String[] choice = tokens[1].split(",");
            if (tokens[0].equals("") || choice.length == 0
                || tokens[2].equals("") || tokens[2 + 1].equals("")
                || tokens.length < FIVE) {
                throw new Exception("Error! Malformed question");
                // return;
            }
            if (choice.length < 2) {
                throw new Exception(tokens[0]
                    + " does not have enough answer choices");
                // return;
            }
            if (Integer.parseInt(tokens[2]) < 1
                || Integer.parseInt(tokens[2]) > choice.length) {
                throw new Exception(
                    "Error! Correct answer choice number is out of range for "
                    + tokens[0]);
                // return;
            }
            if (Integer.parseInt(tokens[2 + 1]) <= 0) {
                throw new  Exception("Invalid max marks for " + tokens[0]);
                // return;
            }
            if (Integer.parseInt(tokens[2 + 2]) > 0) {
                throw new Exception("Invalid penalty for " + tokens[0]);
                // return;
            } else {
                Question ques = new Question(tokens[0], choice,
                    Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[2 + 1]),
                    Integer.parseInt(tokens[2 + 2]));
                quiz.addQuestion(ques);
            }
        // q--;
        }
        System.out.println(temp + " are added to the quiz");
}
    /**
     * Starts a quiz.
     *
     * @param      scan  The scana
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        for (int i = 0; i < quiz.size(); i++) {
        System.out.println(quiz.getQuestion(i).getQuestionText() + "("
            + (quiz.getQuestion(i).getMaxMarks()) + ")");
        quiz.getQuestion(i).setResponse(scan.nextLine());
        String[] answer = quiz.getQuestion(i).getChoice();
            for (int j = 0; j < answer.length - 1; j++) {
            System.out.print(answer[j] + "\t");
        }
        System.out.println(answer[answer.length - 1]);
        System.out.println("");
        }
        // for (int i = 0; i < quiz.size; i++) {
        //  System.out.println(quiz.getQuestion(i));
        // }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        if (quiz.getQuestion(0) != null) {
            int a = 0;
            for (int i = 0; i < quiz.size(); i++) {
            System.out.println(quiz.getQuestion(i).getQuestionText());
            String choice = quiz.getQuestion(i).getResponse();
            // System.out.println(quiz.questions[i].evaluateResponse(choice));
            if (quiz.getQuestion(i).evaluateResponse(choice)) {
                System.out.println(" Correct Answer! - Marks Awarded: "
                    + quiz.getQuestion(i).getMaxMarks());
                a += quiz.getQuestion(i).getMaxMarks();
            } else {
                System.out.println(" Wrong Answer! - Penalty: "
                    + quiz.getQuestion(i).getPenalty());
                a += quiz.getQuestion(i).getPenalty();
            }
            }
            System.out.println("Total Score: " + a);
        }
    }
}
