import univ.*;

/**
 * <h1>Attempt</h1>
 * The Attempt class provides functions/methods for organizing elements of an attempt.
 * @author  Ralph Arvin De Castro
 * @since November 2018
 */

public class Attempt
{
    private Course courseAttempted;
    private String attemptGrade;
    private String semesterTaken;
    
    public Attempt()
    {
        this.courseAttempted = null;
        this.attemptGrade = null;
        this.semesterTaken = null;
    }
    
    public Attempt(Course course, String semester, String grade)
    {
        
        this.courseAttempted = course;
        this.semesterTaken = semester;
        this.attemptGrade = grade;

    }

    /**
     * The setAttemptGrade(String grade) method sets the grade of a course.
     * @param grade grade of the course
     */
    protected void setAttemptGrade(String grade)
    {
        this.attemptGrade = grade;
    }
    
    /**
     * The setAttemptGrade(String grade) method sets the grade of a course.
     * @param grade grade of the course
     */
    public void changeGrade(String grade)
    {
        setAttemptGrade(grade);
    }
    
    /**
     * The getAttemptGrade() method gets the grade of a course.
     * @return grade grade of the course
     */
    public String getAttemptGrade()
    {
        return this.attemptGrade;
    }
    
    /**
     * The setSemesterTaken(String semester) method sets the semester taken of a course.
     * @param semester semester of the course
     */
    protected void setSemesterTaken(String semester)
    {
        this.semesterTaken = semester;
    }
    
    /**
     * The getSemesterTaken() method returns the semester of an attempt.
     * @return semester of an attempt
     */
    public String getSemesterTaken()
    {
        return this.semesterTaken;
    }
    
    /**
     * The setCourseAttempted(Course theCourse) method sets the semester taken of a course.
     * @param semester semester of the course
     */
    protected void setCourseAttempted(Course theCourse)
    {
        this.courseAttempted = theCourse;
    }
    
    /**
     * The getCourseAttempted() method returns the course attempted.
     * @return  course
     */
    public Course getCourseAttempted()
    {
        return this.courseAttempted;
    }
    
    @Override
    public String toString()
    {
        return courseAttempted.getCourseCode() + "," + semesterTaken + "," + attemptGrade;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(((Attempt)o).getCourseAttempted().equals(this.courseAttempted) && (((Attempt)o).semesterTaken.equals(this.semesterTaken)))
        {           
            return true;
        }
        return false;
    }
    
    public boolean equals(String code, String semester)
    {
        if(courseAttempted.equals(code) && semesterTaken.equals(semester))
        {           
            return true;
        }
        return false;
    }
}
