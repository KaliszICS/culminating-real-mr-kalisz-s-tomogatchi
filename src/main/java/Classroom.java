import java.util.Scanner;
public class Classroom{
    //instance variables
    private Tasks[] tasks;
    
    String[] fNames = {
        "Yaseman", "Yu-Yen", "Lily", "Jathav", "Richard", "Aarooran", "Johnathan", "Justin", "Arvin", "Raymond", "Aathi", 
        "Mayuran", "Jackie", "Anastasia", "Elliot", "Jeffery", "Bojan", "Levon", "Safiya", "Rohit"
    };
    String[] lNames = {
        "Nikoo", "Shen", "You", "Puvirajan", "Gao", "Anakan", "Zhao", "Chu", "Deng", "Zeng", "Thavachselvan", 
        "Smith", "Chan", "Liacos", "Chan", "Qiu", "Shepered", "Alexanian", "Haider", "Rajesengar"
    };
    //Used random number generator - Source: https://www.gigacalculator.com/calculators/random-number-generator.php
    String[] studentNumbers = {"381224509", "308971339", "366920888", "394420357", "387095691", "398265364", "393472435", "353896904", "330374857", "314480171",
    "313971991", "358715202", "332013805", "321015205", "360258651", "383708912", "391284753", "392589530", "383044635", "307589604"};

    String[] presence = {"Present", "Absent"};

    int[] volume = {3, 4, 1, 10, 4, 2, 9, 6, 1, 5, 7, 8, 3, 2, 3, 4, 10, 8, 5, 2};

    public Classroom(Scanner input){
        this.tasks = new Tasks[]{new Attendance(input, fNames, lNames, studentNumbers, presence), new MarkingTest(input), new AnswerQuestion(input, fNames, lNames, volume)};
    }

    public void attendanceTask(MrKalisz kalisz){
        Attendance attendance = (Attendance) tasks[0];
        Student[][] seatingChart = attendance.makeSeatingChart(2,6);
        attendance.doAttendance(seatingChart, kalisz);
    }

    public void markTestTask(MrKalisz kalisz){
        MarkingTest markingTest = (MarkingTest) tasks[1];
        markingTest.doMarkingTest(kalisz);
        
    }
    public void answerQuestionTask(MrKalisz kalisz){
        AnswerQuestion answerQuestion = (AnswerQuestion) tasks[2];
        answerQuestion.answerQuestion(kalisz);
    }

}
