/**
 * This Attendance class represents the doAttendance task and extends the abstract class, Tasks. 
 * This class allows users access the class' first names, last names, student numbers and presence.
 * This class contains methods that create a seating chart, make a sorted and present student list, to do the attendance task and changes Mr.Kalisz's energy.
 * @author Lily You
 * @version 1.6
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Attendance extends Tasks{
    private String[] firstNames;
    private String[] lastNames;
    private String[] studentNumbers;
    private String[] presence;
    private Scanner input;

    /**
     * Constructs a new Attendance object with the variables in, firstNames, lastNames, studentNumbers sand presence and initializes the energy cost of this task as 10
     * @param in a Scanner object used to recieve user input
     * @param firstNames String array - list of students' first names
     * @param lastNames String array - list of students' last names
     * @param studentNumbers String array - list of students' student numbers
     * @param presence String array - list of students' presence
     */
    public Attendance(Scanner in, String[] firstNames, String[] lastNames, String[] studentNumbers, String[] presence){
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.studentNumbers = studentNumbers;
        this.presence = presence;
        this.energyCost = 10;
        this.input = in;
    }

    /**
     * Gets the array of students' first names
     * @return the students' first names as a String array
     */
    public String[] getFirstNames(){
        return this.firstNames;
    }

    /**
     * Gets the array of students' last names
     * @return the students' last names as a String array
     */
    public String[] getLastNames(){
        return this.lastNames;
    }

    /**
     * Gets the array of students' student numbers
     * @return the students' student numbers as a String array
     */
    public String[] getStudentNumbers(){
        return this.studentNumbers;
    }

    /**
     * Gets the array of students' presence
     * @return the students' presence as a String array
     */
    public String[] getPresence(){
        return this.presence;
    }

    /**
     * This method creates a 2D array representing a classroom seating chart using the given number of rows and columns
     * @param rows int - the number of rows
     * @param cols int - the number of columns
     * @return a 2D array with the students in the classroom
     */
    public Student[][] makeSeatingChart(int rows, int cols){
        //Uses an arraylist because it's easier to randomize and check for duplicate students
        ArrayList<Student> randomizedList = new ArrayList<>();
        int x = 0;
        //Randomizes which students are in the class from the given arrays
        while(x < (rows*cols)){
            Random rand = new Random();
            int nameIndex = rand.nextInt(firstNames.length);
            int presenceIndex = rand.nextInt(presence.length);
            Student toBeAdded = new Student(this.firstNames[nameIndex], this.lastNames[nameIndex], this.studentNumbers[nameIndex], presence[presenceIndex]);
            //Checks if the student has already been added and keeps creating a new Student to be added if so, otherwise adds it.
            while(randomizedList.contains(toBeAdded)){
               nameIndex = rand.nextInt(20);
               presenceIndex = rand.nextInt(2); 
               toBeAdded = new Student(this.firstNames[nameIndex], this.lastNames[nameIndex], this.studentNumbers[nameIndex], presence[presenceIndex]);
            }
            randomizedList.add(toBeAdded);
            x++;
        }
        //Creates the 2D array of students
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

    /**
     * This method makes an arraylist of students in the class and sorts it
     * @param seatingChart 2D Student array - the students in the classroom
     * @return an arraylist of Students that are sorted by last name
     */
    public ArrayList<Student> makeSortedStudentList(Student[][] seatingChart){
        //Add all the students from the seating chart to an array list for easier sorting purposes
        ArrayList<Student> studentList = new ArrayList<>();
        for(int row = 0; row < seatingChart.length; row++){
            for(int col = 0; col < seatingChart[row].length; col++){
                studentList.add(seatingChart[row][col]);
            }
        }

        //Sort student list using insertion sort
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

    /**
     * This method makes an arraylist of students present in the class
     * @param studentList Student arraylist - the list of students in the class sorted by last name
     * @return an arraylist of Students that are present
     */
    public ArrayList<Student> makeStudentsPresentList(ArrayList<Student> studentList){
        ArrayList<Student> studentsPresent = new ArrayList<>();
        //Checks if the student is present and adds it to the arraylist
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getPresent().equalsIgnoreCase("Present")){
                studentsPresent.add(studentList.get(i));
            }
        }
        return studentsPresent;
    }

    /**
     * This method contains the prompts for the user to play the attendance task
     * @param seatingChart the given 2D Student array representing the seating chart of the class
     * @param kalisz the MrKalisz object whose energy will be affected by the task
     */
    public void doAttendance(Student[][] seatingChart, MrKalisz kalisz){
        DelayText.print("It's time to do your attendance, here's who you see in the class:", 2500);
        //Create the sorted and present student lists
        ArrayList<Student> studentList = makeSortedStudentList(seatingChart);
        ArrayList<Student> studentsPresent = makeStudentsPresentList(studentList);
        
        //Print the seating chart and shows who is present
         for(int row = 0; row < seatingChart.length; row++){
            for(int col = 0; col < seatingChart[row].length; col++){
                DelayText.printSameLine(seatingChart[row][col] + " " + seatingChart[row][col].getPresent() + "       ", 1000);
                if(col == seatingChart[row].length - 1){
                    System.out.println("");
                }
            }
        }  
        
        DelayText.print("\nHere's an ordered list by last name of all the students in your class: ", 1000);
        for(Student name : studentList){
            DelayText.print(name, 1000);
        }

        //Prompts and checks if the user is marking the correct students present and in order by entering the student's first and last name
        //User must cross reference with the seating chart and the sorted student list to check for presence and last name order
        DelayText.print("\nPlease mark those in their seats present IN ORDER BY LAST NAME", 1000);
        for(int i = 0; i < studentsPresent.size(); i++){
            System.out.print("Enter first and last name of student: ");
            String name = input.nextLine();
            //Used regular expression to remove all spaces/whitespaces and dashes in the string for comparison purposes
            String nameNoSpaces = name.replaceAll("[\\s-]","");
            String expectedName = studentsPresent.get(i).toString().replaceAll("[\\s-]","");
            if(nameNoSpaces.equalsIgnoreCase(expectedName)){
                DelayText.print(studentsPresent.get(i) + " is marked here ✅", 500);
            }
            else{
                DelayText.print(name + " is not marked correctly ❌", 500);
                DelayText.print("Expected name: " + studentsPresent.get(i), 500);
                //Each time the user is incorrect, it subtracts 10 energy from Mr.Kalisz
                energyChange(kalisz);
            }

        }
        DelayText.print("Attendance is done!", 2000);
    }

    /**
     * Changes and sets Mr.Kalisz's energy based on his current energy and the energy cost of the task
     * @param kalisz the MrKalisz object whose energy will be changed
     */
    @Override
    public void energyChange(MrKalisz kalisz){
        kalisz.setEnergy(kalisz.getEnergy() - this.energyCost);
    }

}