import java.util.ArrayList;
import java.io.Serializable;
/**
* <h1>Course</h1>
* The Course class provides functions/methods for organizing elements of a course.
* @author  Ralph Arvin De Castro
* @since October 2018
*/
public class Course implements Serializable
{
    private String courseCode;
    private String courseTitle;
    private Double courseCredit;
    private ArrayList<Course> preReqList;
    private String courseStatus;
    private String courseGrade;
    private String courseSemester;
    private String courseType;
    
    public Course()
    {
        this.courseCode = null;
        this.courseTitle = null;
        this.courseCredit = null;
        this.preReqList = null;
        this.courseStatus = null;
        this.courseGrade = null;
        this.courseSemester = null;
    }
    
    public Course(String code, String title, String status, String grade, String semester,double credit, ArrayList<Course> list)
    {
        this.courseCode = code;
        this.courseTitle = title;
        this.courseCredit = credit;
        this.preReqList = list;
        this.courseStatus = status;
        this.courseGrade = grade;
        this.courseSemester = semester;
    }
    
    public Course(Course course)
    {
        this.courseCode = new String(course.courseCode);
        this.courseTitle = new String(course.courseTitle);
        this.courseCredit = new Double(course.courseCredit);
        this.preReqList = course.preReqList;
        this.courseStatus = course.courseStatus;
        this.courseGrade = course.courseGrade;
        this.courseSemester = course.courseSemester;
    }
    
     /**
     * The getCourseCode() method returns the course code of the course.
     * @return course code of the course
     */
    String getCourseCode()
    {
        return this.courseCode;
    }
    
    /**
   * The setCourseCode(String courseCode) method sets the course code of the course..
     * @param courseCode course code of the course
     */
    void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }
    
    /**
   * The getCourseTitle() method returns the title of the course.
     * @return title of the course
     */
    String getCourseTitle()
    {
        return this.courseTitle;
    }
    
    /**
   * The setCourseCode(String courseCode) method sets the title of the course.
     * @param courseTitle title of the course
     */
    void setCourseTitle(String courseTitle)
    {
        this.courseTitle = courseTitle;
    }
    
    /**
   * The getCourseCredit() method returns the credit of the course.
     * @return credit of the course
     */
    double getCourseCredit()
    {
        return this.courseCredit;
    }
    
      /**
   * The setCourseCredit(double credit) method sets the credit of the course.
     * @param credit credit of the course
     */
    void setCourseCredit(double credit)
    {
        this.courseCredit = credit;
    }
    
     /**
   * The getPrerequisites() method returns the prerequisites of a course.
     * @return arraylist prerequisites of a course
     */
    ArrayList<Course> getPrerequisites()
    {
        return this.preReqList;
    }
    
     /**
   * The setPrerequisites (ArrayList<Course> preReqList) method sets the prerequisites of a course.
     * @param preReqList list of prerequisites of the course
     */
    void setPrerequisites (ArrayList<Course> preReqList)
    {
        this.preReqList = preReqList;
    }
    
    /**
     * The setCourseStatus(String courseStatus) method sets the status of a course.
     * @param courseStatus status of the course
     */
    void setCourseStatus(String courseStatus)
    {
        this.courseStatus = courseStatus;
    }
    
    /**
     * The getCourseStatus() method returns the status of a course.
     * @return status of a course
     */
    String getCourseStatus()
    {
        return this.courseStatus;
    }
    
    /**
     * The setCourseGrade(String grade) method sets the grade of a course.
     * @param grade grade of the course
     */
    void setCourseGrade(String grade)
    {
        this.courseGrade = grade;
    }
    
    /**
     * The getCourseStatus() method returns the grade of a course.
     * @return status of a course
     */
    String getCourseGrade()
    {
        return this.courseGrade;
    }
    
    /**
     * The setSemesterTaken(String semester) method sets the semester taken of a course.
     * @param semester semester of the course
     */
    void setSemesterTaken(String semester)
    {
        this.courseSemester = semester;
    }
    
       /**
     * The getSemesterTaken() method returns the semester of a course.
     * @return semester of a course
     */
    String getSemesterTaken()
    {
        return this.courseSemester;
    }
    
        /**
     * The setCourseType method sets the type of a course.
     * @param type type of the course
     */
    void setCourseType(String type)
    {
        this.courseType = type;
    }
    
    /**
     * The getCourseType() method returns the type of a course.
     * @return type of a course
     */
    String getCourseType()
    {
        return this.courseType;
    }

     /**
   * Overriden toString() method
     */
    public String toString()
    {
        return courseCode + ": " + courseTitle + " " + "(" + courseCredit + ")" ;
    }
    
    /**
   * Overriden equals() method
     */
    public boolean equals(Course course)
    {
        if(courseCode.equals(course.getCourseCode()))
        {
            return true;
        }
        return false;
    }
}
