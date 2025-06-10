/**
 * This Classroom class represents the three tasks that Mr.Kalisz can do in the classroom.
 * The three tasks are attendance, marking tests and answering questions.
 * This class provides methods to run the three tasks.
 * @author Yaseman Nikoo
 * @author Yu-Yen Shen
 * @author Lily You
 * @version 1.9
 */

import java.util.Random;
import java.util.Scanner;
public class Classroom{
    private Tasks[] tasks;
    
    //Parallel arrays of Strings that represent the first and last names of students, as well as their student numbers and volume
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

    int[] volume = {3, 4, 1, 10, 4, 2, 9, 6, 1, 5, 7, 8, 10, 2, 3, 4, 9, 8, 5, 2};

    String[] presence = {"Present", "Absent"};

    //Used to generate a random number to be used as the index to create a new Student object
    Random rand = new Random();
    int randomStudentIndex = rand.nextInt(20);

    //Random new Student object that represents the student asking the questions
    Student randomStudent = new Student(fNames[randomStudentIndex], lNames[randomStudentIndex], volume[randomStudentIndex]);

    public Classroom(Scanner input){
        this.tasks = new Tasks[]{new Attendance(input, fNames, lNames, studentNumbers, presence), new MarkingTest(input), new AnswerQuestion(input, randomStudent)};
    }
    /**
     * This method allows the player to access the attendance task.
     * @param kalisz the MrKalisz object that represent the player's character.
     */
    public void attendanceTask(MrKalisz kalisz){
        Attendance attendance = (Attendance) tasks[0];
        Student[][] seatingChart = attendance.makeSeatingChart(2,6);
        attendance.doAttendance(seatingChart, kalisz);
    }
    /**
     * This method allows the player to access the marking test task.
     * @param kalisz the MrKalisz object that represent the player's character.
     */
    public void markTestTask(MrKalisz kalisz){
        MarkingTest markingTest = (MarkingTest) tasks[1];
        markingTest.doMarkingTest(kalisz);
        
    }
    /**
     * This method allows the player to access the answer question task.
     * @param kalisz the MrKalisz object that represent the player's character.
     */
    public void answerQuestionTask(MrKalisz kalisz){
        AnswerQuestion answerQuestion = (AnswerQuestion) tasks[2];
        answerQuestion.answerQuestion(kalisz);
    }

}
