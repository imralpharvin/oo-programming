//package univ;
import univ.*;
import java.util.*;

public class Transcript
{
    ArrayList<Attempt> coursesTaken;
    
    public Transcript()
    {
        coursesTaken = new ArrayList<>();
    }

    void addAttempt(Course course, String grade, String semester)
    {
        Attempt attempt = new Attempt(course, grade, semester);
        
        coursesTaken.add(attempt);
    }
    
    void removeAttempt(String code, String semester)
    {
        for(Iterator<Attempt> i = coursesTaken.iterator(); i.hasNext();)
        {
            Attempt toRemove = i.next();
            
            if(toRemove.equals(code, semester) == true)
            {
                i.remove();
            }            
            
        }

    }
    
    void changeGrade(String code, String semester, String grade)
    {
        for(Attempt attempt: coursesTaken)
        {
            
            if(attempt.equals(code, semester) == true)
            {
                attempt.changeGrade(grade);
            }
        }

    }
    
    protected void setAttempts(ArrayList <Attempt> coursesTaken)
    {
        this.coursesTaken = coursesTaken;
    }
    
    public ArrayList<Attempt> getAttempts()
    {
        return this.coursesTaken;
    }
}
