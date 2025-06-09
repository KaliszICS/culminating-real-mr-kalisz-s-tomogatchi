import java.util.Scanner;
import java.util.Random;

public class MarkingTest extends Tasks{
   private Scanner input;
<<<<<<< HEAD
   public MarkingTest(String studentAnswer, String testAnswer){
    this.studentAnswer = studentAnswer;
    this.testAnswer = testAnswer;
    this.energyCost=5;
=======

   public MarkingTest(Scanner input){
        this.input = input;
        this.energyCost = 10;
>>>>>>> dfd1374 (k)
   }

   //Getters and Seetters
   public Scanner getInput(){
        return this.input;
   }

   public void setInput(Scanner input){
<<<<<<< HEAD
<<<<<<< HEAD
    this.input = input;
=======
    this.input=input;
>>>>>>> c1632d6 (marking test)
   }
    public int findRightAnswers(){
        
=======
        this.input = input;
   }

   //put these variables whereever you would like
   String[] paperAnswers = {"D A A D B D C D D B", "C B C A A D C C B D", "A B D B B A D D C B", "B A B D B C C D C A", "C A D D B A A A C B"};
   String[] correctAnswers = {"D A A B D A C C D B", "D C C A A D B C B A", "A C D B A B D D C A", "B C B D B A D D B A", "C A C D B A D A C B"};
   String studentAnswer;
   String testAnswer;

   public void answers(String[] paperAnswers){
        Random rand = new Random();
        int paperNum = rand.nextInt(5);
        studentAnswer = paperAnswers[paperNum];
        testAnswer = correctAnswers[paperNum];
   }

   public int findRightAnswers(){
        this.testAnswer=this.testAnswer.replaceAll("\\s+","");
>>>>>>> dfd1374 (k)
        this.studentAnswer=this.studentAnswer.replaceAll("\\s+","");
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
<<<<<<< HEAD
    DelayText.print("It's time to mark tests. You have 5 seconds to memorize the students answers. Then, use the test's swer to input how many mistakes the students made.", 4500);
    //insert the picture and delay it for 5 seconds.
    DelayText.print(studentAnswer, 500);
    DelayText.print("Input the number of the write answer: ", 500);
    int num = input.nextInt();
    while(num!=findRightAnswers()){
        DelayText.print("Wrong answer", 500);
        DelayText.print("Input the number of the write answer: ", 500);
        num = input.nextInt();
        energyChange(kalisz);
    }
    DelayText.print("Right answer", 2500);
=======
        DelayText.print("It's time to mark tests. You have 5 seconds to memorize the students answers. Then, use the test's answer to input how many mistakes the students made.", 4500);
>>>>>>> dfd1374 (k)
    
        DelayText.print(studentAnswer, 500);
        DelayText.print("Input the number of the write answer(Format: ?/10): ", 500);
        int num = input.nextInt();
        while(num!=findRightAnswers()){
            DelayText.print("Wrong answer", 2500);
            DelayText.print("Input the number of the write answer: ", 500);
            energyCost+=5;
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
