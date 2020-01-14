import univ.*;
import java.util.*;

public class PlannedTest
{
     
    public PlannedTest()
    {
   
    }

    public static void main(String args[])
    {
        PlannedTest test = new PlannedTest();
        ArrayList<Course> preReq = new ArrayList<>();
        Course course = new Course("CIS*1000", "Programming", 0.5, preReq,"W"  );
        Course course2 = new Course("CIS*2000", "Programming", 0.5, preReq,"W"  );
       
        String semester = "W";
        
        System.out.println("constructorTest: Expected = true, Received = "+ constructorTest());
        System.out.println("constructorTest2: Expected = true, Received = "+ constructorTest2(course, semester));
        System.out.println("setSemesterPlannedTest: Expected = true, Received = "+ setSemesterPlannedTest(semester));
        System.out.println("setSemesterPlannedNullTest: Expected = true, Received = "+ setSemesterPlannedNullTest(null));
        System.out.println("setCoursePlannedTest: Expected = true, Received = "+ setCoursePlannedTest(course));
        System.out.println("setCoursePlannedNullTest: Expected = true, Received = "+ setCoursePlannedNullTest(null));
        
        
    }
    
    public static boolean constructorTest()
    {
        Planned planned = new Planned();
        
        if(planned.getSemesterPlanned() == null && planned.getCoursePlanned() == null) {
            return true;
        }
        
        return false;
    }
    
    public static boolean constructorTest2(Course course, String semester)
    {
        Planned planned = new Planned(course,semester);
        
        if(planned.getSemesterPlanned() != null && planned.getCoursePlanned() != null) {
            return true;
        }
        
        return false;
    }
        
    public static boolean setSemesterPlannedTest(String semester)
    {
        Planned planned = new Planned();
        planned.setSemesterPlanned(semester);
        
        if(planned.getSemesterPlanned().equals("W")) {
            return true;
        }
        
        return false;
    }
    
    public static boolean setSemesterPlannedNullTest(String semester)
    {
        Planned planned = new Planned();
        planned.setSemesterPlanned(semester);
        
        if(planned.getSemesterPlanned() == null)  {
            return true;
        }
        
        return false;
    }
    
    public static boolean setCoursePlannedTest(Course course)
    {
        Planned planned = new Planned();
        planned.setCoursePlanned(course);
        
        if(planned.getCoursePlanned().equals(course)) {
            return true;
        }
        
        return false;
    }
    
    public static boolean setCoursePlannedNullTest(Course course)
    {
        Planned planned = new Planned();
        planned.setCoursePlanned(course);
        
        if(planned.getCoursePlanned() == null) {
            return true;
        }
        
        return false;
    }
}
