/**
 * THis MarkingTest class represents the marking test task and extends the abstract class, Tasks.
 * It ask the player to find the number of the right answers in the students answers.
 * If the player enter the wrong number it will deduct Mr. Kalisz energy
 * @author Yaseman Nikoo
 * @version 1.4 2025/06/09
 */

import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
public class MarkingTest extends Tasks{
   private Scanner input;

   /**
    * This constructor takes in the variable input and sets the energy cost to 5
    * @param input
    */
   public MarkingTest(Scanner input){
    this.input = input;
    this.energyCost = 5;
   }

   /**
    * A method that returns the input of the player.
    * @return the input of the player
    */
   public Scanner getInput(){
        return this.input;
   }

   //Parallel array of Strings that represent the student paper and correct answers
   String[] paperAnswers = {"D A A D B D C D D B", "C B C A A D C C B D", "A B D B B A D D C B", "B A B D B C C D C A", "C A D D B A A A C B"};
   String[] correctAnswers = {"D A A B D A C C D B", "D C C A A D B C B A", "A C D B A B D D C A", "B C B D B A D D B A", "C A C D B A D A C B"};
   String studentAnswer;
   String testAnswer;
   String testAnswerNoSpaces;
   String studentAnswerNoSpaces;
   String paper;

   /**
    * A method that randomly chooses one of the students and tests answers.
    * @param paperAnswers the list that contains the papers answers.
    */
   public void answers(String[] paperAnswers){
        Random rand = new Random();
        int paperNum = rand.nextInt(5);
        studentAnswer = paperAnswers[paperNum];
        testAnswer = correctAnswers[paperNum];
        paper = ASCIIArt.papers(paperNum);
   }

   /**
    * A method that checks the amount of right answers the student has and returns it
    * @return int that represnts the amount of right answers the student has
    */
    public int findRightAnswers(){
        answers(paperAnswers);
        int rightAnswer = 0;
        testAnswerNoSpaces = testAnswer.replaceAll("\\s+","");
        studentAnswerNoSpaces = studentAnswer.replaceAll("\\s+","");
        for(int x = 0; x < testAnswerNoSpaces.length(); x++){
            if(testAnswerNoSpaces.charAt(x) == studentAnswerNoSpaces.charAt(x)){
                rightAnswer += 1;
            }
        }
        return rightAnswer;
   }

   /**
    * This method contains the prompts for user to play the marking test task
    * @param kalisz the object that represeant the character of the player and the energy of the player.
    */
   public void doMarkingTest(MrKalisz kalisz){
    int rightAnswers = findRightAnswers();
    DelayText.print("It's time to mark tests. Then, use the test's answer to input how many answers the students got correct.", 4500);
    System.out.println(paper);
    DelayText.print("These are the correct answers: " + testAnswer, 500);
    //Ask the player to input the number of the right answers from the students paper
    DelayText.printSameLine("Input the number of the right student answers: ", 500);
    boolean validinput=false;
    int num=-1;
     while(!validinput){
        if(input.hasNextInt()){
            validinput=true;
            num=input.nextInt();
        }
        else{
            DelayText.print("Invalid input. Try again:",500);
            input.next();
        }
    }
    //Tell the player whether the player were right or wrong.
        while(num != rightAnswers){
            DelayText.print("Wrong answer", 1000);
            DelayText.printSameLine("Input the number of the right student answers: ", 500);
            validinput=false;
             while(!validinput){
                if(input.hasNextInt()){
                    validinput=true;
                    num=input.nextInt();
                }
                else{
                    DelayText.print("Invalid input. Try again:",500);
                    input.next();
                }
             }
            energyChange(kalisz);
        }
        DelayText.print("Right answer", 1000);
    }

    /**
     * The method that changes the energy of the MrKalisz object.
     * @parm kalisz the object that represeant the character of the player and the energy of the player. 
     */
     @Override
    public void energyChange(MrKalisz kalisz){
        kalisz.setEnergy(kalisz.getEnergy()-this.energyCost);
    }

}
