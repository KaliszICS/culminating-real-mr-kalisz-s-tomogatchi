import java.util.Scanner;
import java.util.ArrayList;
public class Attendance extends Tasks{
    private Student[][] seatingChart;
    private ArrayList<Student> studentList;
    private ArrayList<Student> studentsPresent;

    public Attendance(Student[][] seatingChart, ArrayList<Student> studentList, ArrayList<Student> studentsPresent){
        this.seatingChart = seatingChart;
        this.studentList = studentList;
        this.studentsPresent = studentsPresent;
        this.energyCost = 10;
    }

    //getters
    public ArrayList<Student> getStudentList(){
        return this.studentList;
    }
    public ArrayList<Student> getStudentsPresent(){
        return this.studentsPresent;
    }
    public Student[][] getSeatingChart(){
        return this.seatingChart;
    }

    public void makeSortedStudentList(Attendance attendance){
        //initialize/add all the students in seating chart 2D array to an array list
        for(int row = 0; row < attendance.seatingChart.length; row++){
            for(int col = 0; col < attendance.seatingChart[row].length; col++){
                studentList.add(seatingChart[row][col]);
            }
        }

        //sort student list using insertion sort
        for(int i = 1; i < studentList.size(); i++){
            Student key = studentList.get(i);
            int index = i - 1;
            while(index >= 0 && key.compareTo(studentList.get(index)) < 0){
                studentList.set(index + 1, studentList.get(index));
                index--;
            }
            studentList.set(index + 1, key);
        }
    }

    public void makeStudentsPresentList(Attendance attendance){
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getPresent().equalsIgnoreCase("Present")){
                studentsPresent.add(studentList.get(i));
            }
        }
    }



    @Override
    public int energyChange(MrKalisz kalisz){ //energyChange takes in a MrKalisz object
        return kalisz.getEnergy() - this.energyCost;
    }
    
    @Override
    public boolean checkAnswer(){
        return false;
    }



}