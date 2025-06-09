/**
 * 
 */

import java.util.Scanner;
import java.util.Random;
public class MarkingTest extends Tasks{
   private Scanner input;
   public MarkingTest(Scanner input){
    this.input = input;
    this.energyCost = 5;
   }
<<<<<<< HEAD
<<<<<<< HEAD
    public int findRightAnswers(){
        
=======
=======
>>>>>>> fe327a3 (help)
        this.input = input;
   }
=======

>>>>>>> 6404556 (idk why)
=======

>>>>>>> 5843a88 (more changes sorry guys)

   //put these variables whereever you would like
   String[] paperAnswers = {"D A A D B D C D D B", "C B C A A D C C B D", "A B D B B A D D C B", "B A B D B C C D C A", "C A D D B A A A C B"};
   String[] correctAnswers = {"D A A B D A C C D B", "D C C A A D B C B A", "A C D B A B D D C A", "B C B D B A D D B A", "C A C D B A D A C B"};
   String studentAnswer;
   String testAnswer;
   String testAnswersNoSpaces;
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
        int rightAnswer=0;
        for(int x=0;testAnswer.length()>x;x++){
            if(testAnswer.charAt(x) == studentAnswer.charAt(x)){
                rightAnswer+=1;
            }
        }
        return rightAnswer;
   }

   public void doMarkingTest(MrKalisz kalisz){
    int rightAnswers = findRightAnswers();
    DelayText.print("It's time to mark tests. You have 5 seconds to memorize the students answers. Then, use the test's answer to input how many mistakes the students made.", 4500);
    System.out.println(paper);
    DelayText.print("These are test answer: " + testAnswer, 500);
    DelayText.print("Input the number of the right answer: ", 500);
    int num = input.nextInt();
    while(num != rightAnswers){
        DelayText.print("Wrong answer", 2500);
        DelayText.print("Input the number of the right answer: ", 500);
        num = input.nextInt();
        energyChange(kalisz);
        }
        DelayText.print("Right answer", 2500);
    }
 @Override
    public void energyChange(MrKalisz kalisz){
        kalisz.setEnergy(kalisz.getEnergy()-this.energyCost);
    }

}
