import java.io.Serializable;

/**
* <h1>Student</h1>
* The Student class provides functions/methods for organizing information of a student.
* @author  Ralph Arvin De Castro
* @since October 2018
*/
public class Student implements Serializable
{
    private String firstName;
    private String lastName;
    private Integer studentNumber;
    
    public Student()
    {
        firstName = null;
        lastName = null;
        studentNumber = 0;
    }
    
    public Student(String first,String last,Integer number)
    {
        this.firstName = first;
        this.lastName = last;
        this.studentNumber = number;
    }
    
    
     /**
   * The getFullName() method returns full name of the student.
     * @return full name of the student
     */
    String getFullName()
    {
        return firstName + " " + lastName;
    }
    
      /**
   * The setFirstName(String first) method sets the full name of the student.
     * @param first first name
     */
    void setFirstName(String first)
    {
        firstName = first;
    }
    
    /**
   * The setLastName(String last) method sets the full name of the student.
     * @param last last name
     */
    void setLastName(String last)
    {
        lastName = last;
    }
    
     /**
   * The getFirstName() method returns the first name of the student.
     * @return first name of the student
     */
    String getFirstName()
    {
         return firstName;
    }
    
     /**
   * The getLastName() method returns the last name of the student.
     * @return last name of the student
     */
    String getLastName()
    {
         return lastName;
    }
    
     /**
   * The setLastName(String last) method sets the full name of the student.
     * @param last last name
     */
    void setStudentNumber(Integer studentNum)
    {
        studentNumber = studentNum;
    }
    
       /**
   * The getStudentNumber() method returns the student number of the student.
     * @return student number of the student
     */
    Integer getStudentNumber()
    {
        return studentNumber;
    }
    
    
    public static boolean isNumeric(String str)  
{  
  try  
  {  
    double d = Double.parseDouble(str);  
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;  
}

     /**
   * Overriden toString() method
     */
    public String toString()
    {
        return lastName + ", " + firstName + ":" + studentNumber;
    }
    
    /**
   * Overriden equals() method
     */
    public boolean equals(Student student)
    {
        if(studentNumber.equals(student.getStudentNumber()))
        {
            return true;
        }
        return false;
    }
}
