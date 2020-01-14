
import univ.*;
import java.util.ArrayList;

public class DBConnect{
    private String password;
    private String username;
    private MyConnection c;
    private CourseCatalog catalog;
    private DBStudent student;
    
    public DBConnect(){
        password = DBDetails.password;
        username = DBDetails.username;
        c = new MyConnection(this.username, this.password);
        catalog = new CourseCatalog();
        initializeTables();
        initializeCatalog();
        student = new DBStudent();
    }
    
    public CourseCatalog getCourseCatalog()
    {
        return this.catalog;
    }
    
    public void initializeTables()
    {
        //boolean fullyResetTables = true; //Set this to true if you wish to rebuild/reset your tables!
        //PrepStudentScript initTables = new PrepStudentScript(fullyResetTables); //called to initialize our tables
        //c.deleteAllSavedStudent();
        //c.deleteAllCourses();
        //c.repopulateCourses();
        
    }

    public ArrayList<String> getAllCourses()
    {
        return c.getAllCourses();
    }
    
    public void saveCatalog()
    {
        c.deleteAllCourses();
        
        for(Course course: catalog.getCourseList())
        {
            String credit = String.valueOf(course.getCourseCredit());
            String prereqs = "";
            for(Course prereq: course.getPrerequisites())
            {
                prereqs = prereqs + prereq.getCourseCode() + ":";
            }
            c.addCourse(course.getCourseCode(), credit, course.getCourseTitle(), course.getSemesterOffered(),prereqs );
        }
    }
    
    
    
    public void initializeCatalog()
    {
        ArrayList<String> allCourses = getAllCourses();
        
        for(String course: allCourses)
        {
            String[] keys = course.split(",");
            double credit = 1;
            String[] prereqs = null;
            ArrayList<Course> prerequisites = new ArrayList<Course>();
                
            
            if(keys[1] != null)
            {
                credit = Double.valueOf(keys[1]);
        }
        
            if(keys.length > 4)
            {
                prereqs = keys[4].split(":");
                for(String prereq: prereqs)
                {
                    Course preq = new Course(prereq);
                    prerequisites.add(preq);
                }
        }
        
        Course toAdd = new Course(keys[0], keys[2], credit, prerequisites,keys[3]);
        //System.out.println(toAdd.toString());
        catalog.addCourse(toAdd);
    }
    }
    
    
    public void saveStudent(DBStudent s)
    {
        c.saveStudent(s);
    }
    
    public DBStudent getDBStudent(String id, String name)
    {
        return c.loadStudent(id, name);
    }
    
    public void deleteSavedStudent(String id, String name)
    {
        c.deleteSavedStudent(id,name);
    }
}
    
