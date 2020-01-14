
import univ.*;
import java.util.*;
import java.io.*;
/**
* <h1>Student</h1>
* The Student class provides functions/methods for organizing information of a student.
* @author  Ralph Arvin De Castro
* @since October 2018
*/
public class Student
{
    private String firstName;
    private String lastName;
    private Integer studentNumber;
    private Degree degree;
    private Transcript transcript;
    private PlanOfStudy pos;
   
    
    public Student()
    {
        firstName = null;
        lastName = null;
        studentNumber = 0;
        //degree = new Degree();
        transcript = new Transcript();
        pos = new PlanOfStudy();
    }
    
    public Student(String first,String last,Integer number)
    {
        this.firstName = first;
        this.lastName = last;
        this.studentNumber = number;
        transcript = new Transcript();
        pos = new PlanOfStudy();
    }
    
    /**
     * The getFullName() method returns full name of the student.
     * @return full name of the student
     */
    public String getFullName()
    {
        return firstName + " " + lastName;
    }
    
    /**
     * The setFirstName(String first) method sets the full name of the student.
     * @param first first name
     */
    protected void setFirstName(String first)
    {
        firstName = first;
    }
    
    /**
     * The setLastName(String last) method sets the full name of the student.
     * @param last last name
     */
    protected void setLastName(String last)
    {
        lastName = last;
    }
    
    /**
     * The getFirstName() method returns the first name of the student.
     * @return first name of the student
     */
    public String getFirstName()
    {
         return firstName;
    }
    
    /**
     * The getLastName() method returns the last name of the student.
     * @return last name of the student
     */
    public String getLastName()
    {
         return lastName;
    }
    
    /**
     * The setLastName(String last) method sets the full name of the student.
     * @param last last name
     */
    protected void setStudentNumber(Integer studentNum)
    {
        studentNumber = studentNum;
    }
    
    /**
     * The getStudentNumber() method returns the student number of the student.
     * @return student number of the student
     */
    public Integer getStudentNumber()
    {
        return studentNumber;
    }
    
    /**
    * The setDegreeProgram(Degree deg) method sets the degree program.
    * @param deg Degree class to be set
    */
    protected void setDegreeProgram(Degree deg)
    {
        this.degree = deg;
    }
   
    /**
    * The getDegreeProgram(Degree deg) method returns the degree program.
    * @return deg Degree class
    */
    public Degree getDegreeProgram()
    {
        return this.degree;
    }
    
    
    
    protected void setTranscript(Transcript transcript)
    {
        this.transcript = transcript;
    }
    
    public Transcript getTranscript()
    {
        return this.transcript;
    }
    
    protected void setPlanOfStudy(PlanOfStudy pos)
    {
        this.pos = pos;
    }
    
    PlanOfStudy getPlanOfStudy()
    {
        return this.pos;
    }


    @Override
    public String toString()
    {
        return lastName + "," + firstName;
    }
    
    //to change
    /*public boolean equals(Attempt attempt, String code, String semester)
    {
        if(attempt.getCourseAttempted().getCourseCode().equals(code) && attempt.getCourseAttempted().getCourseSemester().equals(semester))
        {
            return true;
        }
        return false;
    }*/
    
    
}
