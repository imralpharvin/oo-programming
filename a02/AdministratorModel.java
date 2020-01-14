import univ.*;
import java.util.*;

public class AdministratorModel
{
    Administrator administrator;
    public AdministratorModel()
    {
        administrator = new Administrator();
    }


    public void addCoursetoCatalog(String code, String title,String credit, String[]prereqList,String semester)
    {
        ArrayList<Course> prerequisites = new ArrayList<Course>();
        Double dcredit = Double.valueOf(credit);
        for(String precode: prereqList)
        {
            Course pretoAdd = new Course(precode);
            prerequisites.add(pretoAdd);
        }
        
        Course toAdd = new Course(code, title, dcredit, prerequisites, semester);
        administrator.addCourse(toAdd);
    }
    
    public void removeCoursefromCatalog(String code)
    {
        Course toRemove = administrator.database.getCourseCatalog().findCourse(code);
        
        administrator.removeCourse(toRemove);
    }
    
    public void saveCatalog()
    {
        administrator.saveCatalog();
    }
}
