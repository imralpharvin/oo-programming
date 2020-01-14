//package univ;


import java.util.ArrayList;
import univ.*;
/**
* <h1>SEng</h1>
* The SEng class provides functions/methods for organizing elements of a SEng degree.
* @author  Ralph Arvin De Castro
* @since October 2018
*/
public class SEng extends Degree
{
    private static final double anyCIS3AndAbove = 1.0;
    private static final double anyCIS4 = 0.5;
    
    /**
     * The meetsRequirements method returns if student achieves the requirements for a degree
     * @param thePlan plan of student
     * @return boolean
     */   
    public SEng()
    {
        super();
        super.numRequiredCourses = 20.00;
        super.setDegreeTitle("B.Comp. Honours: Software Engineering");
        super.requiredCoursesList = "CIS*1250 CIS*1500 CIS*1910 CIS*2250 CIS*2500 CIS*2030 CIS*2430 CIS*2520 CIS*3250 CIS*2750 CIS*3110 CIS*3490 CIS*3750 STAT*2040 CIS*3760 CIS*3260 CIS*4150 CIS*4300 CIS*4250";
        super.initializeRequiredCourses();
    }
    
    public  boolean meetsRequirements (ArrayList<Course> allTheCoursesPlannedAndTaken)
   {
       double total = 0;
        double cisyear3 = 0;
        double cisyear4 = 0;
       
        
        for(Course course: allTheCoursesPlannedAndTaken)
        {
            String[] split = course.getCourseCode().split("\\*");
            String code = split[0];
            Double number = Double.valueOf(split[1]);
            
            
            if((number >= 3000 && number < 4000) &&code.equals("CIS"))
            {
                cisyear3 += course.getCourseCredit();
            }
            
            if(number >= 4000 && code.equals("CIS"))
            {
                cisyear4 += course.getCourseCredit();
            }
            
            
            total += course.getCourseCredit();
        
    }
    
    if(total >= numRequiredCourses  && (cisyear3 + cisyear4) >= anyCIS3AndAbove && (cisyear3 + cisyear4)  >= anyCIS3AndAbove)
    {
        return true;
    }
        return false;
    }
}