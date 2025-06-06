import java.util.Scanner;

public class MarkingTest extends Tasks{
   private String studentAnswer;
   private String testAnswer;
   private Scanner input;
   public MarkingTest(String studentAnswer, String testAnswer, Scanner input){
    this.studentAnswer = studentAnswer;
    this.testAnswer = testAnswer;
    this.input = input;
    this.energyCost=10;
   }
   //getters and setters
  
   public String getStudentAnswer(){
    return this.studentAnswer;
   }
   public String getTestAnswer(){
    return this.testAnswer;
   }
   public Scanner getInput(){   
        return this.input;
   }
   public void setStudentAnswer(String studentAnswer){
        this.studentAnswer=studentAnswer;
   }
   public void setTestAnswer(String testAnswer){
        this.testAnswer=testAnswer;
   }
<<<<<<< HEAD
   public void setInput(String input){
    this.input = input;
   }
=======
>>>>>>> 3d5066a (changed marking test)
    public int findRightAnswers(){
        this.testAnswer=this.testAnswer.replaceAll("\\s+","");
        this.studentAnswer=this.studentAnswer.replaceAll("\\s+","");
        int rightAnswer=0;
        for(int x=0;this.testAnswer.length()>x;x++){
            if(this.testAnswer.charAt(x)==this.studentAnswer.charAt(x)){
                rightAnswer+=1;
            }
        }
        return rightAnswer;
   }
   public void doMarkingTest(MrKalisz kalisz){
    DelayText.print("It's time to mark tests. You have 5 seconds to memorize the students answers. Then, use the test's naswer to input how many mistakes the students made.", 4500);
    //insert the picture and delay it for 5 seconds.
    DelayText.print(studentAnswer, 500);
    DelayText.print("Input the number of the write answer: ", 500);
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
