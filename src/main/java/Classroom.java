import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;
public class Classroom{
    //instance variables
    private Attendance attendance;
    private MarkingTest markingTest;
    //private AnswerQuestion answerQuestion;
    private Scanner input;
    
    String[] fNames = {
        "Yaseman", "Yu-Yen", "Lily", "Jathav", "Richard", "Aarooran", "Johnathan", "Justin", "Arvin", "Raymond", "Aathi", 
        "Mayuran", "Jackie", "Anastasia", "Elliot", "Jeffery", "Bojan", "Levon", "Safiya", "Rohit"
    };
    String[] lNames = {
        "Nikoo", "Shen", "You", "Puvirajan", "Gao", "Anakan", "Zhao", "Chu", "Deng", "Zeng", "Thavachselvan", 
        "Smith", "Chan", "Liacos", "Chen", "Qiu", "Shepered", "Alexanian", "Haider", "Rajesengar"
    };
    //Used random number generator - Source: https://www.gigacalculator.com/calculators/random-number-generator.php
    String[] studentNumbers = {"381224509", "308971339", "366920888", "394420357", "387095691", "398265364", "393472435", "353896904", "330374857", "314480171",
    "313971991", "358715202", "332013805", "321015205", "360258651", "383708912", "391284753", "392589530", "383044635", "307589604"};
    String[] presence = {"Present", "Absent"};

    public Classroom(Scanner input){
        this.attendance = new Attendance(fNames, lNames, studentNumbers, presence);
        this.input = input;
    }

    public void attendanceTask(MrKalisz kalisz){
        attendance.setInput(this.input);
        Student[][] seatingChart = attendance.makeSeatingChart(2,6);
        attendance.doAttendance(seatingChart, kalisz);
    }

    public double markTestTask(MrKalisz kalisz){
        return 0.0;
    }
    public void answerQuestion(MrKalisz kalisz){

    }

}