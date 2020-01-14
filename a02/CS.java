//package univ;

import java.util.ArrayList;
import univ.*;
/**
* <h1>CS</h1>
* The CS class provides functions/methods for organizing elements of a CS degree.
* @author  Ralph Arvin De Castro
* @since October 2018
*/

public class CS extends Degree
{
    private static final double anyCIS3AndAbove = 1.5;
    private static final double anyCIS4 = 1.5;
    public CS()
    {
        super();
        super.numRequiredCourses = 20.00;
        super.setDegreeTitle("B.Comp. Honours: Computer Science");
        super.requiredCoursesList = "CIS*1500 MATH*1200 CIS*1910 CIS*2500 CIS*2030 CIS*2430 CIS*2520 CIS*2910 CIS*2750 CIS*3110 CIS*3490 CIS*3150 CIS*3750 CIS*2460 CIS*3760 CIS*4650";
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