import java.util.ArrayList;
import java.io.Serializable;
/**
* <h1>BCG</h1>
* The BCG class provides functions/methods for organizing elements of a BCG degree.
* @author  Ralph Arvin De Castro
* @since October 2018
*/

public class BCG extends Degree implements Serializable
{
    private double any3AndAbove;
    private double any1;
    private double oneDiscipline;
    private double cis2AndAbove;
    private double cis3AndAbove;
    private double science;
    ArrayList<Course> allRequired;
  
    
    public BCG()
    {
        super();
        super.setDegreeTitle("B.Comp. General");
        super.numRequiredCourses = 15.00;
        any3AndAbove = 4.00;
        any1 = 6.00;
        oneDiscipline = 11.00;
        cis2AndAbove = 0.50;
        cis3AndAbove = 1.00;
        science = 2.00;
        allRequired = new ArrayList<Course>();
    }
  
  /**
     * The meetsRequirements method returns if student achieves the requirements for a degree
     * @param thePlan plan of student
     * @return boolean
     */   
     boolean meetsRequirements(PlanOfStudy thePlan)
     {
        if(super.numberOfCurrentCredits(thePlan) >= super.numRequiredCourses && meet1stRequirement(thePlan) == true && meet3rdRequirement(thePlan) == true && meet3rdRequirement(thePlan) == true && meet4thRequirement(thePlan) == true)
        {
            return true;
    }
    return false;
     }
     
     boolean meet1stRequirement(PlanOfStudy thePlan)
     {
         double all1st = 0.00;
         double all3rdandAbove = 0.00;
         boolean rule1 = false;
         boolean rule3andAbove = false;
         
         for(Course course: thePlan.getCourseList())
              {
                    String[] keys = course.getCourseCode().split("\\*");
                     if(keys[1].charAt(0) == '1')
                     {
                         all1st += course.getCourseCredit();
                     }
                     
              }
              
         if(all1st < any1)
         {
             rule1 = true;
            }
            
            
          for(Course course: thePlan.getCourseList())
              {
                    String[] keys = course.getCourseCode().split("\\*");
                     if(keys[1].charAt(0) == '3' || keys[1].charAt(0) == '4')
                     {
                         all3rdandAbove += course.getCourseCredit();
                     }
                     
              }
              
         if(all3rdandAbove >= any3AndAbove)
         {
             rule3andAbove = true;
            }
         
            if(rule1 == true && rule3andAbove == true)
         {
             return true;
            }
         return false;
        }
     
     boolean meet2ndRequirement(PlanOfStudy thePlan)
     {
         double allCIS = 0.00;
         
         for(Course course: thePlan.getCourseList())
              {
                    String[] keys = course.getCourseCode().split("\\*");
                     if(keys[0].equals("CIS"))
                     {
                         allCIS += course.getCourseCredit();
                     }
                     
              }
              
         if(allCIS > oneDiscipline)
         {
             return false;
            }
            
         return true;
        }
     
      boolean meet3rdRequirement(PlanOfStudy thePlan)
     {
         boolean requiredCourses = false;
         boolean cis2plus = false;
         boolean cis3plus = false;
         boolean cis2 = false;
         ArrayList<Course> cis2pluslist = new ArrayList<Course>();
         ArrayList<Course> toRemove = new ArrayList<Course>();
         
         if(super.remainingRequiredCourses(thePlan) == null || super.remainingRequiredCourses(thePlan).isEmpty())
         {
             requiredCourses = true;
             this.allRequired = completedRequiredCourses(thePlan);
         }
         else
         {
             return false;
             
         }
         //get all 2nd and above course
         for(Course course: thePlan.getCourseList())
         { 
             String[] keys = course.getCourseCode().split("\\*");
             if(keys[0].equals("CIS") && (keys[1].charAt(0) == '2' || keys[1].charAt(0) == '3' || keys[1].charAt(0) == '4'))
             {
                 cis2pluslist.add(course);
             }
             
         }
         //remove all required courses from 2nd
         for(Course course: allRequired)
         {
   
             if(thePlan.findCourse(cis2pluslist, course.getCourseCode()) != null)
             {
                 cis2pluslist.remove(thePlan.findCourse(cis2pluslist, course.getCourseCode()));
                 
             }
             
         }
         
         if(cis2pluslist.isEmpty() )
         {
             return false;
              
         }
         else
         {
              for(Course course: cis2pluslist)
              {
                    String[] keys = course.getCourseCode().split("\\*");
                     if(keys[0].equals("CIS") && keys[1].charAt(0) == '2')
                     {
                         allRequired.add(course);
                         cis2plus = true;
                         cis2 = true;
                         break;
                     }
                     
              }
              
              
         }
         
         for(Course course: allRequired)
         {
   
             if(thePlan.findCourse(cis2pluslist, course.getCourseCode()) != null)
             {
                 cis2pluslist.remove(thePlan.findCourse(cis2pluslist, course.getCourseCode()));
                 
             }
             
         }
         
        if(cis2 == false)
         {
             for(Course course: cis2pluslist)
              {
                    String[] keys = course.getCourseCode().split("\\*");
                     if(keys[0].equals("CIS") && (keys[1].charAt(0) == '3' || keys[1].charAt(0) == '4'))
                     {
                         allRequired.add(course);
                         cis2plus = true;
                         break;
                     }
                     
              }
            }
      
        for(Course course: allRequired)
         {
   
             if(thePlan.findCourse(cis2pluslist, course.getCourseCode()) != null)
             {
                 cis2pluslist.remove(thePlan.findCourse(cis2pluslist, course.getCourseCode()));
                 
             }
             
         }
        
         for(int i = 1; i<3; i++)
         {
         if(cis2pluslist.isEmpty() )
         {
             return false;
         }
         else
         {
              for(Course course: cis2pluslist)
              {
                    String[] keys = course.getCourseCode().split("\\*");
                     if(keys[0].equals("CIS") && (keys[1].charAt(0) == '3' || keys[1].charAt(0) == '4'))
                     {
                         allRequired.add(course);
                         if( i == 2)
                         {
                         cis3plus = true;
                         return true;//delete later
                        }
                         break;
                     }
                     
              }
              
              
             
            }
           for(Course course: allRequired)
         {
   
             if(thePlan.findCourse(cis2pluslist, course.getCourseCode()) != null)
             {
                 cis2pluslist.remove(thePlan.findCourse(cis2pluslist, course.getCourseCode()));
                 
             }
             
             
         }
        }
        
        
         return false;
     }
     
     boolean meet4thRequirement(PlanOfStudy thePlan)
     {
         double allnonCIS = 0.00;
         
         for(Course course: thePlan.getCourseList())
              {
                    String[] keys = course.getCourseCode().split("\\*");
                     if(!keys[0].equals("CIS"))
                     {
                         allnonCIS += course.getCourseCredit();
                     }
                     
              }
              
         if(allnonCIS >= science)
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
        if(deg instanceof BCG)
        {
            return true;
        }
        return false;
    }
}
