import java.util.Random;
import java.util.Scanner;

public class AnswerQuestion extends Tasks{
    int energyCost = 20;

    String[] questionsArr = {
        "What's a variable?", 
        "So, can a abstract method have a body?", 
        "How old are you?", 
        "May I use the washroom", 
        "How many permutations does Ball have?"
    };

    String[][] answerArr = {
        {"A number.", "Stores and represents information.", "A class."},
        {"Yes.", "No.", "Sometimes."},
        {"No idea.", "I don't know", "Really young."},
        {"No.", "Go ahead.", "Why?"},
        {"12", "6", "24"}
    };

    int[] correctAnswerIndex = {1, 1, 2, 1, 0};
    
    Student student = new Student("Bob", "Ross", "342404090","Present");

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

    @Override
    public void energyChange(MrKalisz kalisz) {
        
    }
}
