
import univ.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
* <h1>Bootstrap</h1>
* The Bootstrap application provides functions/methods for admnistrators to organize courses and provide degree information.
*
* @author  Ralph Arvin De Castro
* @since October 2018
*/

public class Administrator
{
   public DBConnect database;
   private ArrayList<Degree> degreeList;
   
   public Administrator()
   {
       database = new DBConnect();
       //allCourses = new CourseCatalog();
       degreeList = new ArrayList<Degree>();
   }
   
    public void addCourse(Course course)
    {
        database.getCourseCatalog().addCourse(course);
        //allCourses.addCourse(course);
    }
    
    public void removeCourse(Course course)
    {
       database.getCourseCatalog().removeCourse(course);
       //allCourses.removeCourse(course);
    }
    
    public void saveCatalog()
    {
       database.saveCatalog();
    }

    /**
    * The createFileMenu() method prompts user to input file that has all the courses and load it to the application.
    */
    public void loadCoursesFile()
    {
     

    }

    /**
    * The loadRequiredCoursesFile() method prompts user to input file that has all the required courses of a degree.
    */
    public void loadRequiredCoursesFile()
    {
      
    }

    /**
    * The saveFiles() method saves both files created.
    */
    public void saveFiles()
    {
      
    }
    
   /**
   * Overriden toString() method
   */
    public String toString()
    {
        return "Bootstrap";
    }
    
 
}
