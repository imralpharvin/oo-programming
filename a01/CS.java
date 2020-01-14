import java.util.ArrayList;
import java.io.Serializable;
/**
* <h1>CS</h1>
* The CS class provides functions/methods for organizing elements of a CS degree.
* @author  Ralph Arvin De Castro
* @since October 2018
*/

public class CS extends Degree implements Serializable
{
    private double anyCIS3AndAbove;
    private double anyCIS4;
    public CS()
    {
        super();
        super.numRequiredCourses = 20.00;
        super.setDegreeTitle("B.Comp. Honours: Computer Science");
        anyCIS4 = 1.5;
        anyCIS3AndAbove = 1.5;
    }
  
  
     /**
     * The meetsRequirements method returns if student achieves the requirements for a degree
     * @param thePlan plan of student
     * @return boolean
     */   
     boolean meetsRequirements(PlanOfStudy thePlan)
     {
         boolean rule4 = false;
         boolean rule3AndAbove = false;
         double credit3AndAbove = 0.00;
         double credit4 = 0.00;
         ArrayList<Course> checkedCourses = new ArrayList<Course>();
         ArrayList<Course> unCheckedCourses = new ArrayList<Course>();
         
         
         for(Course course: super.completedCourses(thePlan))
        {
             unCheckedCourses.add(course);
        }
        
        for(Course course: thePlan.getDegreeProgram().getRequiredCourses())
         {
   
             if(thePlan.findCourse(unCheckedCourses, course.getCourseCode()) != null)
             {
                 unCheckedCourses.remove(thePlan.findCourse(unCheckedCourses, course.getCourseCode()));
                 
             }
             
         }
         
         for(Course course: unCheckedCourses)
        {
                String[] keys = course.getCourseCode().split("\\*");
                 if(keys[0].equals("CIS") && keys[1].charAt(0) == '4' && credit4 < anyCIS4)
                 {
                     credit4 += course.getCourseCredit();
                     checkedCourses.add(course);
                 }
                     
         }
         for(Course course: checkedCourses)
         {
   
             if(thePlan.findCourse(unCheckedCourses, course.getCourseCode()) != null)
             {
                 unCheckedCourses.remove(thePlan.findCourse(unCheckedCourses, course.getCourseCode()));
                 
             }
             
         }
         
         if(credit4 >= anyCIS4)
         {
             System.out.println(anyCIS4);
             rule4 = true;
         }
         
         for(Course course: unCheckedCourses)
        {
                String[] keys = course.getCourseCode().split("\\*");
                 if(keys[0].equals("CIS") && (keys[1].charAt(0) == '3' || keys[1].charAt(0) == '4') && credit3AndAbove < anyCIS3AndAbove)
                 {
                     credit3AndAbove += course.getCourseCredit();
                     checkedCourses.add(course);
                 }
                     
         }
         for(Course course: checkedCourses)
         {
   
             if(thePlan.findCourse(unCheckedCourses, course.getCourseCode()) != null)
             {
                 unCheckedCourses.remove(thePlan.findCourse(unCheckedCourses, course.getCourseCode()));
                 
             }
             
         }
         if(credit3AndAbove >= anyCIS3AndAbove)
         {
            
             rule3AndAbove = true;
         }
   
         if(super.remainingRequiredCourses(thePlan).isEmpty() && super.numberOfCurrentCredits(thePlan) >= super.numRequiredCourses && rule4 == true && rule3AndAbove == true)
         {
         return true;
        }
        
        return false;
     }
     
      public String toString()
    {
        return super.getDegreeTitle();
    }
    
    public boolean equals(Degree deg)
    {
        if(deg instanceof CS)
        {
            return true;
        }
        return false;
    }
}
