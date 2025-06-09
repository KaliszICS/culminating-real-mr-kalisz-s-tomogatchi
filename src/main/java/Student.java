public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private String studentNumber;
    private int volume;
    private String present;

    /**
     * constructor for students attendance
     * @param firstName student's first name
     * @param lastName student's last name
     * @param studentNumber student's student number
     * @param present student's present or not
     */
    public Student(String firstName, String lastName, String studentNumber, String present){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.present = present;
    }

    /**
     * constructor for students volume
     * @param firstName student's first name
     * @param lastName student's last name
     * @param volume student's volume while speaking
     */
    public Student(String firstName, String lastName, int volume){
        this.firstName = firstName;
        this.lastName = lastName;
        this.volume = volume;
    }

    /**
     * get student's first name
     * @return student's first name
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * get student's last name
     * @return student's last name
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * get student number
     * @return student number
     */
    public String getStudentNumber(){
        return this.studentNumber;
    }

    /**
     * get student's volume
     * @return student's volume while asking question
     */
    public int getVolume(){
        return this.volume;
    }

    /**
     * get student's attendance
     * @return whether the student is present or absent
     */
    public String getPresent(){
        return this.present;
    }

    
    /**
     * set student's volume while asking question
     * @param volume the volume student has when asking the question
     */
    public void setVolume(int volume){
        this.volume = volume;
    }

    /**
     * @return student's full name in the format of "firstName lastName"
     */
    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }

    /**
     * @return the difference of letters of the student's last names
     */
    @Override
    public int compareTo(Student student){
        return this.lastName.compareToIgnoreCase(student.lastName);
    }

    /**
     * @return if the student is completely equal to the object student
     */
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