import java.util.Random;
import java.util.Scanner;

/**
 * a task where the player answers the student's questions in class
 * the energy cost depends on whether the answer is correct or not
 */
public class AnswerQuestion extends Tasks{
    private Student student;

    /**
     * 
     * @param student the student who is asking the question
     */
    public AnswerQuestion(Student student){
        this.student = student;
        //The base energy cost for answering question
        this.energyCost = 5;
    }

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
    public int answerQuestion(String[] questionArr, String[][] answerArr, MrKalisz kalisz){
        Scanner in = new Scanner(System.in);
        //randomize questions asked by student using an array of questions and random number
        Random num = new Random();

        int questionNum = num.nextInt(questionsArr.length);
        int studentVolume = this.student.getVolume();

        System.out.println("Student asks: " + questionArr[questionNum]);

        while (studentVolume <= 4){
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
            energyCost = 5;
            energyChange(kalisz);
        } else {
            System.out.println("Wrong...you lose more energy.");
            energyCost = 10;
            energyChange(kalisz);
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
        kalisz.setEnergy(kalisz.getEnergy() - this.energyCost);
    }
}
