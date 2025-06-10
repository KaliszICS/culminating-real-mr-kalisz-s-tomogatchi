/**
 * This Student class allows the user to access a student's first name, last name, student number volume and presence of a student and modify a student's volume.
 * This class implements the Comparable interface and is used to sort students by last name.
 * This class contains methods that return the student's name in a readable format, compares two students and checks if two students are equal.
 * @author 
 * @version 1.3
 */

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private String studentNumber;
    private int volume;
    private String present;

    /**
     * Constructor for student's attendance
     * @param firstName String of the student's first name
     * @param lastName String of student's last name
     * @param studentNumber String of student's student number
     * @param present String of student's presence
     */
    public Student(String firstName, String lastName, String studentNumber, String present){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.present = present;
    }

    /**
     * Constructor for a student using the variables firstName, lastName and volume
     * @param firstName String of the student's first name
     * @param lastName String of the student's last name
     * @param volume int of the student's volume while speaking
     */
    public Student(String firstName, String lastName, int volume){
        this.firstName = firstName;
        this.lastName = lastName;
        this.volume = volume;
    }

    /**
     * Get student's first name
     * @return student's first name as a String
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Get student's last name
     * @return student's last name as a String
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * Get the student's student number
     * @return student number as a String
     */
    public String getStudentNumber(){
        return this.studentNumber;
    }

    /**
     * Get student's volume
     * @return student's volume as an int
     */
    public int getVolume(){
        return this.volume;
    }

    /**
     * Get student's attendance
     * @return whether the student is present or absent as a String
     */
    public String getPresent(){
        return this.present;
    }

    
    /**
     * Set student's volume
     * @param volume int - the new volume of the student
     */
    public void setVolume(int volume){
        this.volume = volume;
    }

    /**
     * Returns the name of student in a readable format
     * @return student's full name as String in the format of "firstName lastName"
     */
    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }

    /**
     * Compares two students using the alphabetical order of their last names
     * @param student the Student object being compared
     * @return a negative integer, zero or a positive integer if this student's last name is less than, equal to, or greater than the given student's last name, respectively
     */
    @Override
    public int compareTo(Student student){
        return this.lastName.compareToIgnoreCase(student.lastName);
    }

    /**
     * Checks if two students are equal by comparing the student numbers
     * @param obj the given Student object to be compared with
     * @return ture if the student is has the same student numbers, otherwise false
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj){ 
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){ 
            return false;
        }
        Student student = (Student)obj;
        if(student.getStudentNumber().equals(this.studentNumber)){
            return true;
        }
        return false;
    }
}