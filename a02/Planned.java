import univ.*;

public class Planned
{
    private Course coursePlanned;
    private String semesterPlanned;
    
    public Planned()
    {
        this.coursePlanned = null;
        this.semesterPlanned = null;
    }
    
    public Planned(Course course, String semester)
    {
        this.coursePlanned = course;
        this.semesterPlanned = semester;

    }
    
    
    /**
     * The setSemesterTaken(String semester) method sets the semester taken of a course.
     * @param semester semester of the course
     */
    public void setSemesterPlanned(String semester)
    {
        if(semester == null)
        {
            System.out.println("Semester is null");
            return;
        }
        this.semesterPlanned = semester;
    }
    
    /**
     * The getSemesterTaken() method returns the semester of a course.
     * @return semester of a course
     */
    public String getSemesterPlanned()
    {
        return this.semesterPlanned;
    }
    
    public void setCoursePlanned(Course theCourse)
    {
        if(theCourse == null)
        {
            System.out.println("Course is null");
            return;
        }
        this.coursePlanned = theCourse;
    }
    
    public Course getCoursePlanned()
    {
        return this.coursePlanned;
    }
    
    @Override
    public String toString()
    {
        return coursePlanned.getCourseCode() + "," + semesterPlanned;
    }
    
    public boolean equals(String code, String semester)
    {
        if(coursePlanned.equals(code) && semesterPlanned.equals(semester)){           
            return true;
        }
        return false;
    }
}
