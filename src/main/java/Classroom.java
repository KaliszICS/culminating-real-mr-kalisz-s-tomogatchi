import java.util.ArrayList;
import java.util.Scanner;
public class Classroom{
    //instance variables
    private Attendance attendance;
    private Scanner input;

    Student[][] seatingChart = new Student[][] {
            {new Student("Lily", "You", "Present"), new Student("Yu-Yen", "Shen", "Present")},
            {new Student("Jathav", "Puvirajan", "Absent"), new Student("Yaseman", "Nikoo", "Present")}
    };

    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Student> studentsPresent = new ArrayList<>();

    public Classroom(Scanner input){
        this.attendance = new Attendance(seatingChart, studentList, studentsPresent);
        this.input = input;
    }

    public void doAttendance(MrKalisz kalisz){
        DelayText.print("It's time to do your attendance, here's who you see in the class:", 2500);
        attendance.makeSortedStudentList(this.attendance);
        attendance.makeStudentsPresentList(this.attendance);
        //will be replaced by an image?
         for(int row = 0; row < seatingChart.length; row++){
            for(int col = 0; col < seatingChart[row].length; col++){
                DelayText.print(seatingChart[row][col] + " " + seatingChart[row][col].getPresent(), 1000);
            }
        }  
        
        DelayText.print("\nHere's an ordered list by last name of all the students in your class: ", 1000);
        for(Student name : attendance.getStudentList()){
            DelayText.print(name, 1000);
        }

        DelayText.print("\nPlease mark those in their seats present IN ORDER BY LAST NAME", 1000);
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
            }

        }

        int energyLeft = attendance.energyChange(kalisz);
        DelayText.print("Attendance is done! Current energy: " + energyLeft, 3000);
    }
}