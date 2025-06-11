/**
 * This AnswerQuestion class represents the answer question task and extends the abstract class, Tasks. 
 * This class contains a method for the answer question task where the player answers the student's questions in class
 * As well as, a method that changes Mr.Kalisz's energy.
 * @author Yu-Yen Shen
 * @version 1.5 2025/06/07
 */

import java.util.Random;
import java.util.Scanner;
public class AnswerQuestion extends Tasks{
    private Student student;
    private Scanner input;

    /**
     * Constructs a new AnswerQuestion object with the variables input and student
     * @param input the Scanner object used to receive user input
     * @param student the Student object that represents the random student who is asking the question
     */
    public AnswerQuestion(Scanner input, Student student){
        this.input = input;
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
        {"No idea.", "I don't know.", "Really young."},
        {"No.", "Go ahead.", "Why?"},
        {"12", "6", "24"}
    };

    int[] correctAnswerIndex = {1, 1, 2, 1, 0}; // Indexes of correct answer
    

    /** 
     * This method contains the prompts for user the answer question task
     * @param kalisz the MrKalisz object whose energy will be changed by the task
     */
    public void answerQuestion(MrKalisz kalisz){
        //Randomize questions asked by student using an array of questions and random number
        Random num = new Random();

        int questionNum = num.nextInt(questionsArr.length);
        int studentVolume = this.student.getVolume();

        //Student asks a question
        DelayText.print("Student asks: " + questionsArr[questionNum],1000);

        //The student's volume will be tested, if not loud enough, they will be asked to repeat until the volume is sufficient
        while (studentVolume <= 4){
            DelayText.print("Say that again?", 1000);
            studentVolume++;
            student.setVolume(studentVolume);
        }

        //The player selects an answer
        DelayText.print("Choose the correct answer: ", 1000);
        for (int i = 0; i < 3; i++) {
            DelayText.print((i + 1)+": " + answerArr[questionNum][i], 1000);
        }

        int playerChoice = input.nextInt();
        
        //Check for invalid input first
        if (playerChoice != 1 && playerChoice != 2 && playerChoice != 3) {
            System.out.println("The choice is invalid. Please try again.");
            answerQuestion(kalisz);
            return;
        }

        //Energy cost depending on whether the answer is correct or not
        if (playerChoice - 1 == correctAnswerIndex[questionNum]) {
            System.out.println("Correct!");
            energyCost = 5;
        } 
        else {
            System.out.println("Wrong...you lose more energy.");
            energyCost = 10;
        }
        energyChange(kalisz);
    }

    /**
     * Energy change to Mr. Kalisz
     * @param kalisz the MrKalisz object whose energy is going to change
     */
    @Override
    public void energyChange(MrKalisz kalisz) {
        kalisz.setEnergy(kalisz.getEnergy() - this.energyCost);
    }
}
