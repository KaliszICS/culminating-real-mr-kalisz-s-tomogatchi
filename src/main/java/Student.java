public class Student{
    private String firstName;
    private String lastName;
    private String studentNumber;
    private int grade;
    private int volume;

    //constructor for the students?
    public Student(String firstName, String lastName, String studentNumber, int grade, int volume){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.grade = grade;
        this.volume = volume;
    }

    //getters
    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getStudentNumber(){
        return this.studentNumber;
    }

    public int getGrade(){
        return this.grade;
    }

    public int getVolume(){
        return this.volume;
    }

    
    //setters
    public void setVolume(int volume){
        this.volume = volume;
    }

}