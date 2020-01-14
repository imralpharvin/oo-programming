import java.util.ArrayList;
import java.io.Serializable;
/**
* <h1>Degree</h1>
* The Degree abstract class provides functions/methods for organizing general elements of a degree.
* @author  Ralph Arvin De Castro
* @since October 2018
*/
public abstract class Degree implements Serializable
{
     private String degreeTitle;
     private ArrayList<Course> requiredCourses; 
     Double numRequiredCourses;
     
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
     void setDegreeTitle(String title)
     {
         this.degreeTitle = title;
     }
     
     /**
     * The setRequiredCourses method sets the required courses.
     * @param listOfRequiredCourseCodes
     */
     void setRequiredCourses(ArrayList<String> listOfRequiredCourseCodes)
     {
         CourseCatalog allCourses = new CourseCatalog();
         allCourses.initializeCatalog("allCourses.csv");
         
         for(String courseCode: listOfRequiredCourseCodes)
         {
             Course course = new Course(allCourses.findCourse(courseCode));
             course.setCourseType("Required");
             requiredCourses.add(course);
         }
         
     }
     
     /**
     * The getRequiredCourses() method returns the required courses.
     * @return required courses
     */
     ArrayList<Course> getRequiredCourses()
     {
         return this.requiredCourses;
     }
     
     /**
     * The numberOfCurrentCredits method returns the number of current credits in the degree.
     * @param thePlan plan of student
     * @return current credit
     */
     double numberOfCurrentCredits(PlanOfStudy thePlan)
     {
         double numberOfCreditsRequired = 0;
         double numberOfCreditsAcquired = 0;
         for(Course course: thePlan.getCourseList())
         {
             int grade;
             try
             {
                 if(Integer.valueOf(course.getCourseGrade()) != null)
                 {
                     grade =  Integer.valueOf(course.getCourseGrade());
                     if(course.getCourseStatus().equals("Completed") && grade >= 50 )
                     {
                         numberOfCreditsAcquired += course.getCourseCredit();
                     }
                 }
             }
            catch(NumberFormatException nfe)
            {
                
            }
        
         }
         return numberOfCreditsAcquired;
     }
     
     /**
     * The remainingRequiredCourses method returns the list of remaining courses.
     * @param thePlan plan of student
     * @return list of remaining required courses
     */
     ArrayList<Course> remainingRequiredCourses(PlanOfStudy thePlan)
     {
         ArrayList<Course> completedCourses = new ArrayList<>();
         ArrayList<Course> remainingCourses = new ArrayList<>();
         for(Course course: thePlan.getCourseList())
         {
             int grade;
             try
             {
                 if(Integer.valueOf(course.getCourseGrade()) != null)
                 {
                     grade =  Integer.valueOf(course.getCourseGrade());
                     if(course.getCourseStatus().equals("Completed") && grade >= 50 )
                     {
                         completedCourses.add(course);
                     }
                 }
             }
            catch(NumberFormatException nfe)
            {
                
            }
             /*if(course.getCourseStatus().equals("Completed") )
             {
                 completedCourses.add(course);
             }*/
         }
         
         for(Course course: requiredCourses)
         {
             if(thePlan.findCourse(completedCourses, course.getCourseCode()) == null)
             {
                 remainingCourses.add(course);
             }
         }
         
         
         return remainingCourses;
     }
     
     /**
     * The numberOfCreditsRemaining method returns the number of remaining credits in the degree.
     * @param thePlan plan of student
     * @return remaining credit
     */
     double numberOfCreditsRemaining(PlanOfStudy thePlan)
     {
         if((numRequiredCourses - numberOfCurrentCredits(thePlan)) < 0)
         {
             return 0;
         }
         return numRequiredCourses - numberOfCurrentCredits(thePlan);
     }
     
     /**
     * The completedCourses method returns the list of completed courses in the degree.
     * @param thePlan plan of student
     * @return list of completed courses
     */
     ArrayList<Course> completedCourses(PlanOfStudy thePlan)
     {
         ArrayList<Course> completedCourses = new ArrayList<>();
         Integer grade;
         for(Course course: thePlan.getCourseList())
         {  
             try
             {
             grade =  Integer.valueOf(course.getCourseGrade());
                 if(course.getCourseStatus().equals("Completed") && grade >= 50 )
                 {
                     completedCourses.add(course);
                 }
            }
              catch(NumberFormatException nfe)
            {
            }
         }
    
         return completedCourses;
     }
     
     /**
     * The completedRequiredCourses method returns the list of completed required courses in the degree.
     * @param thePlan plan of student
     * @return list of completed required courses
     */
     ArrayList<Course> completedRequiredCourses(PlanOfStudy thePlan)
     {
         ArrayList<Course> completedCourses = new ArrayList<>();
         ArrayList<Course> completedRequiredCourses = new ArrayList<>();
         Integer grade;
         
         for(Course course: thePlan.getCourseList())
         {
             try{
             grade =  Integer.valueOf(course.getCourseGrade());
             if(course.getCourseStatus().equals("Completed") && grade >= 50 )
             {
                 completedCourses.add(course);
             }
            }
            catch(NumberFormatException nfe)
            {
            }
         }
         
     
         for(Course course: requiredCourses)
         {
             
             if(thePlan.findCourse(completedCourses, course.getCourseCode()) != null)
             {
                 completedRequiredCourses.add(course);
             }
         }
         return completedRequiredCourses;
     }
     
     /**
   * Overriden toString() method
     */
     public String toString()
    {
        return degreeTitle;
    }
    
    /**
   * Overriden equals() method
     */
    public boolean equals(Degree deg)
    {
        if(deg instanceof Degree)
        {
            return true;
        }
        return false;
    }
}
