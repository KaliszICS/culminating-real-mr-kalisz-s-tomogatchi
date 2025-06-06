import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Attendance extends Tasks{
    private String[] firstNames;
    private String[] lastNames;
    private String[] studentNumbers;
    private String[] presence;
    private Scanner input;

    public Attendance(String[] firstNames, String[] lastNames, String[] studentNumbers, String[] presence){
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.studentNumbers = studentNumbers;
        this.presence = presence;
        this.energyCost = 10;
    }

    //getters
    public String[] getFirstNames(){
        return this.firstNames;
    }

    public String[] getLastNames(){
        return this.lastNames;
    }

    public String[] presence(){
        return this.presence;
    }

    /*public Scanner input(){
        return this.input;
    }*/

    //setters
    public void setFirstNames(String[] firstNames){
        this.firstNames = firstNames;
    }

    public void setLastNames(String[] lastNames){
        this.lastNames = lastNames;
    }

    public void setPresence(String[] presence){
        this.presence = presence;
    }

    public void setInput(Scanner input){
        this.input = input;
    }


    public Student[][] makeSeatingChart(int rows, int cols){
        ArrayList<Student> randomizedList = new ArrayList<>();
        int x = 0;
        while(x < (rows*cols)){
            Random rand = new Random();
            int nameIndex = rand.nextInt(20);
            int presenceIndex = rand.nextInt(2);
            Student toBeAdded = new Student(this.firstNames[nameIndex], this.lastNames[nameIndex], this.studentNumbers[nameIndex], presence[presenceIndex]);
            while(randomizedList.contains(toBeAdded)){
               nameIndex = rand.nextInt(20);
               presenceIndex = rand.nextInt(2); 
               toBeAdded = new Student(this.firstNames[nameIndex], this.lastNames[nameIndex], this.studentNumbers[nameIndex], presence[presenceIndex]);
            }
            randomizedList.add(toBeAdded);
            x++;
        }
        Student[][] seatingChart = new Student[rows][cols];
        x = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){  
                seatingChart[i][j] = randomizedList.get(x);
                x++;
            }  
        }
        return seatingChart;
    }

    public ArrayList<Student> makeSortedStudentList(Student[][] seatingChart){
        //initialize/add all the students in seating chart 2D array to an array list
        ArrayList<Student> studentList = new ArrayList<>();
        for(int row = 0; row < seatingChart.length; row++){
            for(int col = 0; col < seatingChart[row].length; col++){
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
        return studentList;
    }

    public ArrayList<Student> makeStudentsPresentList(ArrayList<Student> studentList){
        ArrayList<Student> studentsPresent = new ArrayList<>();
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getPresent().equalsIgnoreCase("Present")){
                studentsPresent.add(studentList.get(i));
            }
        }
        return studentsPresent;
    }

    public void doAttendance(Student[][] seatingChart, MrKalisz kalisz){
        DelayText.print("It's time to do your attendance, here's who you see in the class:", 2500);
        ArrayList<Student> studentList = makeSortedStudentList(seatingChart);
        ArrayList<Student> studentsPresent = makeStudentsPresentList(studentList);
        //will be replaced by an image?
         for(int row = 0; row < seatingChart.length; row++){
            for(int col = 0; col < seatingChart[row].length; col++){
                DelayText.print(seatingChart[row][col] + " " + seatingChart[row][col].getPresent(), 1000);
            }
        }  
        
        DelayText.print("\nHere's an ordered list by last name of all the students in your class: ", 1000);
        for(Student name : studentList){
            DelayText.print(name, 1000);
        }

        DelayText.print("\nPlease mark those in their seats present IN ORDER BY LAST NAME", 1000);
        int energyLeft = kalisz.getEnergy();
        for(int i = 0; i < studentsPresent.size(); i++){
            System.out.print("Enter first and last name of student: ");
            String name = input.nextLine();
            //used regular expression to remove all spaces/whitespaces in the string, should we also ignore like dashes, for example Yu-Yen's name.
            String nameNoSpaces = name.replaceAll("\\s+","");
            String expectedName = (studentsPresent.get(i).getFirstName() + studentsPresent.get(i).getLastName());
            if(nameNoSpaces.equalsIgnoreCase(expectedName)){
                DelayText.print(studentsPresent.get(i) + " is marked here ✅", 1000);
            }
            else{
                DelayText.print(studentsPresent.get(i) + " is not marked correctly ❌", 1000);
                energyLeft = energyChange(kalisz);
            }

        }
        DelayText.print("Attendance is done! Current energy: " + energyLeft, 3000);
    }

    @Override
    public int energyChange(MrKalisz kalisz){ //energyChange takes in a MrKalisz object
        //set new kalisz energy
        kalisz.setEnergy(kalisz.getEnergy() - this.energyCost);
        return kalisz.getEnergy();
    }
    
    @Override
    public boolean checkAnswer(){
        return false;
    }

}