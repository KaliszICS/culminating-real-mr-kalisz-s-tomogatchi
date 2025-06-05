public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private String studentNumber;
    private int mark;
    private int volume;
    private String present;

    //constructor for the students?
    public Student(String firstName, String lastName, String studentNumber, int mark, int volume, String present){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.mark = mark;
        this.volume = volume;
        this.present = present;
    }

    public Student(String firstName, String lastName, String present){
        this.firstName = firstName;
        this.lastName = lastName;
        this.present = present;
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

    public int getMark(){
        return this.mark;
    }

    public int getVolume(){
        return this.volume;
    }

    public String getPresent(){
        return this.present;
    }

    
    //setters
    public void setVolume(int volume){
        this.volume = volume;
    }

    //methods
    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }

    @Override
    public int compareTo(Student student){
        return this.lastName.compareToIgnoreCase(student.lastName);
    }

}