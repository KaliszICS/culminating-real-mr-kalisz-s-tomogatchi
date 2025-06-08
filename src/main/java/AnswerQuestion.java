import java.util.Random;
import java.util.Scanner;

/**
 * a task where the player answers the student's questions in class
 * the energy cost depends on whether the answer is correct or not
 */
public class AnswerQuestion extends Tasks{
    int energyCost = 10; // the base energy cost for answering questions

    String[] questionsArr = { // 5 questions
        "What's a variable?", 
        "So, can a abstract method have a body?", 
        "How old are you?", 
        "May I use the washroom", 
        "How many permutations does Ball have?"
    };

    String[][] answerArr = { // 3 choices of answers for each question
        {"A number.", "Stores and represents information.", "A class."},
        {"Yes.", "No.", "Sometimes."},
        {"No idea.", "I don't know", "Really young."},
        {"No.", "Go ahead.", "Why?"},
        {"12", "6", "24"}
    };

    int[] correctAnswerIndex = {1, 1, 2, 1, 0}; // indexes of correct answer
    
    Student student = new Student("Bob", "Ross", "342404090","Present");
    // the student asking the question

    /**
     * student asking a question and the player selecting an answer
     * the student's volume will be tested, if not loud enough, he will be asked to repeat until the volume is sufficient
     * energy cost depending on whether the answer is correct or not
     * 
     * @param questionArr the array of questions asked
     * @param student the student asking questions
     * @param answerArr the choices of the answer for each question
     * @param energyCost the base energy cost for answering the question
     * @return the update energy cost after answering the question depending on right or wrong
     */
    public int answerQuestion(String[] questionArr, Student student, String[][] answerArr, int energyCost){
        Scanner in = new Scanner(System.in);
        //randomize questions asked by student using an array of questions and random number
        Random num = new Random();

        int questionNum = num.nextInt(questionsArr.length);
        int studentVolume = student.getVolume();

        System.out.println("Student asks: " + questionArr[questionNum]);

        while (studentVolume <= 3){
            System.out.println("Say that again?");
            studentVolume++;
            student.setVolume(studentVolume);
        }

        System.out.println("Choose the correct answer: ");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1)+": " + answerArr[questionNum][i]);
        }

        int playerChoice = in.nextInt();
        
        if (playerChoice - 1 == correctAnswerIndex[questionNum]) {
            System.out.println("Correct:");
            energyCost = 10;
        } else {
            System.out.println("Wrong...you lose more energy.");
            energyCost = 20;
        }

        return energyCost;
    }

    /**
     * energy change to Mr. Kalisz
     * 
     * @param kalisz the MrKalisz object whose energy is going to change
     */
    @Override
    public void energyChange(MrKalisz kalisz) {
        
    }
}
