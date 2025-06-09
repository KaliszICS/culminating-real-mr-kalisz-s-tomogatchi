import java.util.Random;
import java.util.Scanner;

/**
 * a task where the player answers the student's questions in class
 * the energy cost depends on whether the answer is correct or not
 */
public class AnswerQuestion extends Tasks{
    private Student student;
    private Scanner input;

    Random rand = new Random();
    int randomStudent = rand.nextInt(20);

    /**
     * 
     * @param student the student who is asking the question
     */
    public AnswerQuestion(Scanner in, String[] fNames, String[] lNames, int[] volume){
        this.input = in;
        this.student = new Student(fNames[randomStudent], lNames[randomStudent], volume[randomStudent]);
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
    public void answerQuestion(MrKalisz kalisz){
        //randomize questions asked by student using an array of questions and random number
        Random num = new Random();

        int questionNum = num.nextInt(questionsArr.length);
        int studentVolume = this.student.getVolume();

        DelayText.print("Student asks: " + questionsArr[questionNum],1000);

        while (studentVolume <= 4){
            DelayText.print("Say that again?", 1000);
            studentVolume++;
            student.setVolume(studentVolume);
        }

        DelayText.print("Choose the correct answer: ", 1000);
        for (int i = 0; i < 3; i++) {
            DelayText.print((i + 1)+": " + answerArr[questionNum][i], 1000);
        }

        int playerChoice = input.nextInt();
        
        if (playerChoice - 1 == correctAnswerIndex[questionNum]) {
            System.out.println("Correct:");
            energyCost = 5;
            energyChange(kalisz);
        } else {
            System.out.println("Wrong...you lose more energy.");
            energyCost = 10;
            energyChange(kalisz);
        }
    }

    /**
     * Energy change to Mr. Kalisz
     * 
     * @param kalisz the MrKalisz object whose energy is going to change
     */
    @Override
    public void energyChange(MrKalisz kalisz) {
        kalisz.setEnergy(kalisz.getEnergy() - this.energyCost);
    }
}
