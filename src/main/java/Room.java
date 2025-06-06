import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract class Room{
    protected Student[][] seatingChart;
    protected ArrayList<Student> studentList;
    protected int rows;
    protected int cols;

    public Room(int rows, int cols){
        this.seatingChart = new Student[rows][cols];
        this.studentList = new ArrayList<>();
    }


}