/*import java.util.Random;
import java.util.Scanner;


public class AnswerQuestion extends Tasks{
    int energyCost = 5;// idk

    String[] questionsArr = {"What's a variable?", "So, can a abstract method have a body?", "How old are you?", "May I use the washroom", "How many permutations does Ball have?"};
    String[] answerArr = {"How are you asking that now? - Energy Cost: 1 \n Stores and represents information? Energy Cost: 4", "Yes - Energy Cost: 2 \n No - Energy Cost: 1", "No - Energy Cost: 1 \n 46 - Energy Cost: 2"};
    
    Student student = new Student("Bob", "Ross", "342404090", 12, 5, "Present");


    public String answerQuestion(String[] questionArr, Student student, String[] answerArr, int energyCost){
        Scanner in = new Scanner(System.in);
        //randomize questions asked by student using an array of questions and random number
        Random num = new Random();
        int questionNum = num.nextInt(3);

        System.out.println(questionArr[questionNum]);
        int studentVolume = student.getVolume();
        if(studentVolume <= 3){
            System.out.println("Say that again?");
            student.setVolume(studentVolume++);
        }

        else{
            System.out.println("Options to answer the question: " + answerArr[num]);
            System.out.println("Answer:");
            String ans = in.nextLine();
            energyCost = 5;
        }
        return energyCost;
    }

    @Override
    public int energyChange(){
        return 0;
    }
    @Override
    public boolean checkAnswer(){
        return false;
    }
    
} */

//not finish yet
class AnswerQuestion extends Task {
    protected int energyCost;
    private int volume;
    private int countAnswerTime;

    public String checkVolume(int volume){
        this.volume = volume;
        if (this.volume < 10) {
            return "Sorry say that again?";
            countAnswerTime++;
            checkVolume();
        } else {
            return "What did I just say?";
            countAnswerTime++;
        }
    }

    public void energyChange(){
        if (countAnswerTime >= 3){
            energy = energy - energyCost;
        }
    }
}