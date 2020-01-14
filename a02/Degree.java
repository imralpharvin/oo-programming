//package univ;
import univ.*;
import java.util.ArrayList;

/**
* <h1>Degree</h1>
* The Degree abstract class provides functions/methods for organizing general elements of a degree.
* @author  Ralph Arvin De Castro
* @since October 2018
*/
public abstract class Degree
{
     protected String degreeTitle; 
     protected String requiredCoursesList;
     protected ArrayList<Course> requiredCourses; 
     protected Double numRequiredCourses;
     
     public Degree()
     {
         degreeTitle = null;
         requiredCourses = new ArrayList<Course>();
         
     }
     
     /**
     * The getDegreeTitle() method returns the degree title.
     * @return degree title.
     */
     String getDegreeTitle()
     {
        return this.degreeTitle;
     }
     
     /**
     * The setDegreeTitle(String title) method sets the degree title.
     * @param title degree title
     */
     protected void setDegreeTitle(String title)
     {
        try{
            if(title == null) {
                throw new NullPointerException();
            }
            this.degreeTitle = title;
        }
        
        catch(NullPointerException e){
            System.out.println("Degree title input does not exist!");
            return;
        }
         
     }
     
/**
     * The setRequiredCourses method sets the required courses.
     * @param listOfRequiredCourseCodes
     */
    protected void setRequiredCourses(ArrayList<Course> listOfRequiredCourseCodes)
    {
        this.requiredCourses = listOfRequiredCourseCodes;
    }
     
    /**
    * The getRequiredCourses() method returns the required courses.
    * @return required courses
    */
    public ArrayList<Course> getRequiredCourses()
    {
        return this.requiredCourses;
    }
     
    protected void initializeRequiredCourses()
    {
       DBConnect database = new DBConnect();
       ArrayList<Course> courseList= new ArrayList<>();
       
       String[] splitCourses = requiredCoursesList.split(" ");
       for(String course: splitCourses)
       {
           courseList.add(database.getCourseCatalog().findCourse(course));
       }
       
       setRequiredCourses(courseList);
    }
    

     
    public double numberOfCreditsPlannedAndCompleted(ArrayList<Course> allTheCoursesPlannedAndTaken)
    {
        double totalCredits = 0;
        
        for(Course course: allTheCoursesPlannedAndTaken)
        {
            totalCredits = totalCredits + course.getCourseCredit();
        }

        
        return totalCredits;
    }
    
    public double numberOfCreditsRemaining(ArrayList<Course> allTheCoursesPlannedAndTaken)
    {
        return numRequiredCourses - numberOfCreditsPlannedAndCompleted(allTheCoursesPlannedAndTaken);
    }
     
    public ArrayList<Course> remainingRequiredCourses(ArrayList<Course> allTheCoursesPlannedAndTaken)
    {
        
       ArrayList<Course> missingCoursesPOS = new ArrayList<Course>();
       
        for(Course course: requiredCourses)
        {
            if(findCourse(allTheCoursesPlannedAndTaken, course) == null)
            {
                missingCoursesPOS.add(course);
            }
        }
        
        return missingCoursesPOS;
    }
    
    public abstract boolean meetsRequirements (ArrayList<Course> allTheCoursesPlannedAndTaken);
    
    public Course findCourse(ArrayList<Course> courses, Course theCourse)
    {
        for(Course course: courses)
        {
            if(course.equals(theCourse.getCourseCode()))
            {
                return course;
            }
        }
        
        return null;
    }
}
