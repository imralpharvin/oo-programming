//package univ;

import univ.*;
import java.util.*;

public class PlanOfStudy
{
    ArrayList<Planned> coursesPlanned;
    
    public PlanOfStudy()
    {
        coursesPlanned = new ArrayList<>();
    }

    void addCoursetoPlan(Course course, String semester)
    {
        Planned toAdd = new Planned(course, semester);
 
             
        coursesPlanned.add(toAdd);
    }
    
    void removeCoursefromPlan(Course course, String semester)
    {
        for(Iterator<Planned> i = coursesPlanned.iterator(); i.hasNext();)
        {
            Planned toRemove = i.next();
            
            if(toRemove.equals(course) == true)
            {
                i.remove();
            }
        }

    }
    
    protected void setCoursesPlanned(ArrayList <Planned> coursesPlanned)
    {
        this.coursesPlanned = coursesPlanned;
    }
    
    public ArrayList<Planned> getCoursesPlanned()
    {
        return this.coursesPlanned;
    }
}
