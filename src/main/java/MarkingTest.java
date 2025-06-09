/**
 * Represeant the marking test task. It ask the player to find the number of the right answers in the students answers. If the player enter the wrong number it will deduct Mr. Kalisz energy
 * @author Yaseman Nikoo
 * @veersion 1.4 2025/6/09
 */

import java.util.Scanner;
import java.util.Random;
public class MarkingTest extends Tasks{
   private Scanner input;
   /**
    * The contructor only set the value of the energy cost for the 
    */
   public MarkingTest(){
        this.energyCost=5;
   }

   //Getters and Seetters
   public Scanner getInput(){
        return this.input;
   }


   //put these variables whereever you would like
   String[] paperAnswers = {"D A A D B D C D D B", "C B C A A D C C B D", "A B D B B A D D C B", "B A B D B C C D C A", "C A D D B A A A C B"};
   String[] correctAnswers = {"D A A B D A C C D B", "D C C A A D B C B A", "A C D B A B D D C A", "B C B D B A D D B A", "C A C D B A D A C B"};
   String studentAnswer;
   String testAnswer;
   String testAnswerNoSpaces;
   String studentAnswerNoSpaces;

   String paper;

   public void answers(String[] paperAnswers){
        Random rand = new Random();
        int paperNum = rand.nextInt(5);
        studentAnswer = paperAnswers[paperNum];
        testAnswer = correctAnswers[paperNum];
        paper = ASCIIArt.papers(paperNum);
   }

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

   public void doMarkingTest(MrKalisz kalisz){
    int rightAnswers = findRightAnswers();
    DelayText.print("It's time to mark tests. You have 5 seconds to memorize the students answers. Then, use the test's answer to input how many mistakes the students made.", 4500);
    System.out.println(paper);
    DelayText.print("These are the correct answers: " + testAnswer, 500);
    DelayText.printSameLine("Input the number of the right student answers: ", 500);
    int num = input.nextInt();
    input.nextLine();
        while(num != rightAnswers){
            DelayText.print("Wrong answer", 1000);
            DelayText.printSameLine("Input the number of the right student answers: ", 500);
            num = input.nextInt();
            energyChange(kalisz);
        }
        DelayText.print("Right answer", 1000);
    }
 @Override
    public void energyChange(MrKalisz kalisz){
        kalisz.setEnergy(kalisz.getEnergy()-this.energyCost);
    }

}
