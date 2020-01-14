//package univ;
import univ.*;
import java.util.ArrayList;

/**
* <h1>BCG</h1>
* The BCG class provides functions/methods for organizing elements of a BCG degree.
* @author  Ralph Arvin De Castro
* @since October 2018
*/

public class BCG extends Degree
{
    private static final double required3AndAbove = 4.00;
    private static final double max1 = 6.00;
    private static final double maxoneDiscipline = 11.00;
    private static final double requiredCIS2AndAbove = 0.50;
    private static final double requiredCIS3AndAbove = 1.00;
    private static final double science = 2.00;
    
    public BCG()
    {
        super();
        super.setDegreeTitle("B.Comp. General");
        super.requiredCoursesList =  "CIS*1500 CIS*1910 CIS*2430 CIS*2500 CIS*2520 CIS*2750 CIS*2910 CIS*3530";
        super.numRequiredCourses = 15.00;
        super.initializeRequiredCourses();
    }
    
    public boolean meetsRequirements (ArrayList<Course> allTheCoursesPlannedAndTaken)
    {
        double total = 0;
        double cis = 0;
        double notcis = 0;
        double year1 = 0;
        double year2 = 0;
        double year3 = 0;
        double year4 = 0;
       
        
        for(Course course: allTheCoursesPlannedAndTaken)
        {
            String[] split = course.getCourseCode().split("\\*");
            String code = split[0];
            Double number = Double.valueOf(split[1]);
            
            
            if(code.equals("CIS"))
            {
                cis += course.getCourseCredit();
            }
            
            else
            {
                notcis += course.getCourseCredit();
            }
            
            if(number < 2000)
            {
                year1 += course.getCourseCredit();
            }
            
            if(number >= 2000 && number < 3000)
            {
                year2 += course.getCourseCredit();
            }
            
            if(number >= 3000 && number < 4000)
            {
                year3 += course.getCourseCredit();
            }
            
            if(number >= 4000)
            {
                year4 += course.getCourseCredit();
            }
            
            if((!((year1 > max1) && (number < 2000))) && (!(cis > maxoneDiscipline && code.equals("CIS") ) )) 
            {
                total += course.getCourseCredit();
        }
    }
    
    if(total >= numRequiredCourses  && (year2 + year3 + year4) >= requiredCIS2AndAbove && (year3 + year4)  >= requiredCIS2AndAbove)
    {
        return true;
    }
    return false;
}
}