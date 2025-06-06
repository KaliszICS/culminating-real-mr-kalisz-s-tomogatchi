public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private String studentNumber;
    private double mark;
    private int volume;
    private String present;

    //constructor for the students marks
    public Student(String firstName, String lastName, double mark){ //i made mark a double
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }

    //constructor for students attendance
    public Student(String firstName, String lastName, String studentNumber, String present){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.present = present;
    }

    //constructor for students volume
    public Student(String firstName, String lastName, int volume){
        this.firstName = firstName;
        this.lastName = lastName;
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

    public double getMark(){
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

    @Override
    public boolean equals(Object o){
         if(this == o){ 
            return true;
        }
        if(o == null || getClass() != o.getClass()){ 
            return false;
        }
        Student student = (Student)o;
        if(student.getStudentNumber().equals(this.studentNumber)){
            return true;
        }
        return false;
    }

}