package univ;

import java.util.ArrayList;

/**
 * <h1>Course</h1>
 * The Course class provides functions/methods for organizing elements of a course.
 * @author  Ralph Arvin De Castro
 * @since October 2018
 */

public class Course
{
    private String courseCode;
    private String courseTitle;
    private Double courseCredit;
    private ArrayList<Course> preReqList;
    private String semesterOffered;
    
    public Course()
    {
        this.courseCode = null;
        this.courseTitle = null;
        this.courseCredit = null;
        this.preReqList = null;
        this.semesterOffered = null;
    }
    
    public Course(String code)
    {
        this.courseCode = code;
        this.courseTitle = null;
        this.courseCredit = null;
        this.preReqList = null;
        this.semesterOffered = null;
    }
    
    public Course(Course course)
    {
        this.courseCode = new String(course.courseCode);
        this.courseTitle = new String(course.courseTitle);
        this.courseCredit = new Double(course.courseCredit);
        this.preReqList = course.preReqList;
        this.semesterOffered = new String(course.semesterOffered);
    }
    
    public Course(String code, String title, double credit, ArrayList<Course> prereq, String semester) //to delete?
    {
        this.courseCode = code;
        this.courseTitle = title;
        this.courseCredit = credit;
        this.preReqList =prereq;
        this.semesterOffered = semester;
    }
            
    /**
     * The getCourseCode() method returns the course code of the course.
     * @return course code of the course
     */
    public String getCourseCode()
    {
        return this.courseCode;
    }
      
    /**
     * The setCourseCode(String courseCode) method sets the course code of the course..
     * @param courseCode course code of the course
     */
    protected void setCourseCode(String courseCode)
    {
        try{
            if(courseCode == null) {
                throw new NullPointerException();
            }
            this.courseCode = courseCode;
        }
        
        catch(NullPointerException e){
            System.out.println("Course code input does not exist!");
            return;
        }
        
    }
    
    /**
     * The getCourseTitle() method returns the title of the course.
     * @return title of the course
     */
    public String getCourseTitle()
    {
        return this.courseTitle;
    }
    
    /**
     * The setCourseCode(String courseCode) method sets the title of the course.
     * @param courseTitle title of the course
     */
    protected void setCourseTitle(String courseTitle)
    {
        try{
            if(courseTitle == null) {
                throw new NullPointerException();
            }
            this.courseTitle = courseTitle;
        }
        
        catch(NullPointerException e){
            System.out.println("Course Title input does not exist!");
            return;
        }
        
    }
    
    
    /**
     * The getCourseCredit() method returns the credit of the course.
     * @return credit of the course
     */
    public double getCourseCredit()
    {
        return this.courseCredit;
    }
    
    /**
     * The setCourseCredit(double credit) method sets the credit of the course.
     * @param credit credit of the course
     */
    protected void setCourseCredit(double credit) 
    {
        try{ 
            if(credit < 0) {
                throw new InvalidInputException();
            
            }
            
            this.courseCredit = credit;
        }
        
        catch(InvalidInputException e){
            System.out.println("Course credit input does not exist");
            return;
        }
        
    }
    
    /**
     * The getPrerequisites() method returns the prerequisites of a course.
     * @return arraylist prerequisites of a course
     */
    public ArrayList<Course> getPrerequisites()
    {
        return this.preReqList;
    }
    
    /**
     * The setPrerequisites (ArrayList<Course> preReqList) method sets the prerequisites of a course.
     * @param preReqList list of prerequisites of the course
     */
    protected void setPrerequisites (ArrayList<Course> preReqList)
    {       
        this.preReqList = preReqList;        
    }
    
    /**
     * The getSemesterOffered() method returns the semester offered of a course.
     * @return string semester offered
     */
    public String getSemesterOffered()
    {
        return this.semesterOffered;
    }
    
    /**
     * The setSemesterOffered(String semesterOffered) method sets the offered semesters of a course.
     * @param semesterOffered offered semester
     */
    protected void setSemesterOffered(String semesterOffered)
    {
        try{
            if(semesterOffered== null) {
                throw new NullPointerException();
            }
            this.semesterOffered = semesterOffered;
        }
        
        catch(NullPointerException e){
            System.out.println("Semester input does not exist!");
            return;
        }
        
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(((Course)o).getCourseCode().equals(this.courseCode))
        {
            return true;            
        }        
        return false;
        
    }
    
    @Override
    public String toString()
    {
        return courseCode + " (" + courseTitle + ", " + courseCredit + ", " + semesterOffered + ")"; 
    }
    
    public boolean equals(String code)
    {
        if(courseCode.equals(code))
        {
            return true;            
        }        
        return false;
        
    }
}
