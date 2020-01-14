import java.util.ArrayList;
import java.io.*;
/**
* <h1>CourseCatalog</h1>
* The CourseCatalog class provides functions/methods and creates a catalog for users to organize elements of courses..
* @author  Ralph Arvin De Castro
* @since October 2018
*/
public class CourseCatalog
{
    private ArrayList<Course> courseList;
    
    public CourseCatalog()
    {
        courseList = new ArrayList<Course>();
    }
    
     /**
   * The initializeCatalog(String filename) method loads the file that has all the courses and put it to the catalog
     */
    void initializeCatalog(String filename)
    {
        File file = new File(filename);
        String line;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader (file));

             while ((line = br.readLine()) != null) 
             {     
                
                 String[] words = line.split(",");
                 
                 Course course = new Course();
                 course.setCourseCode(words[0]);
                 course.setCourseCredit(Double.parseDouble(words[1]));
                 course.setCourseTitle(words[2]);
                 
                if(words.length > 3)
                {
                 String[] preReqs = words[3].split(":");
                 ArrayList<Course> preRequisites = new ArrayList<>();
                 for(String preReq: preReqs)
                 {
                     Course preReqCourse = new Course();
                     preReqCourse.setCourseCode(preReq);
                     preRequisites.add(preReqCourse);
                 }
                 course.setPrerequisites(preRequisites);
                }
                 courseList.add(course);
                 
                
             }
             
             for(Course added: this.courseList)
                {
                    
                    if(added.getPrerequisites() != null)
                    {
                         ArrayList<Course> newPrereq = new ArrayList<>();
                        for(Course preReq: added.getPrerequisites())
                    {
                        
                       
                        String code = new String(preReq.getCourseCode());
                        preReq = new Course(findCourse(preReq.getCourseCode()));
                        newPrereq.add(preReq);
                        
                    }
                        added.setPrerequisites(newPrereq);
                }
                }
                
        }
    
        catch (FileNotFoundException ex)
        {
            System.out.println("No such file");
        }
        
        catch (IOException ioex)
        {
            System.out.println("No such file");
        }
    }
    
    /**
     * The addCourse(Course toAdd) method adds a course in the course list
     * @param toAdd course to add
     */
    void addCourse(Course toAdd)
    {
        courseList.add(toAdd);
    }
    
    /**
     * The removeCourse(Course toRemove) method removes a course in the course list
     * @param toRemove course to remove
     */
    void removeCourse(Course toRemove)
    {
        courseList.remove(toRemove);
    }
    
    /**
   * The saveCatalog() method saves the course catalog in a csv file
     */
    void saveCatalog()
    {
        try
      {
          FileWriter file = new FileWriter("allCourses.csv");
         
          for(Course course: courseList)
          {
              file.append(course.getCourseCode());
              file.append(",");
              file.append(Double.toString(course.getCourseCredit()));
              file.append(",");
              file.append(course.getCourseTitle());
              file.append(",");
              if(course.getPrerequisites() != null)
              {
              file.append(course.getPrerequisites().get(0).getCourseCode());
              
              if(course.getPrerequisites().size() > 1)
              {
                  for(int i = 1; i < course.getPrerequisites().size(); i++)
                  {
                       
                       file.append(":");
                       file.append(course.getPrerequisites().get(i).getCourseCode());
                  }
                }
            }
              file.append("\n");
         }
         
         file.flush();
         file.close();
      } 
      catch (FileNotFoundException ex)
        {
            System.out.println("No such file");
        }
        
        catch (IOException ioex)
        {
            System.out.println("No such file");
        }
    
      
   }
    
      /**
     * The findCourse() method finds a course in the course list and returns it
     * @param courseCode code of a course
     * @return course list
     */
    Course findCourse(String courseCode)
    {
        for(Course course: courseList)
        {
            if(courseCode.equals(course.getCourseCode())) 
            {
                return course;
            }
        
        }
        
        return null; 
    }
    
     /**
     * The getCourseList() method returns the course list.
     * @return course list
     */
    ArrayList<Course> getCourseList()
    {
        return courseList;
    }
    
    /**
   * Overriden toString() method
     */
    public String toString()
    {
        return "Course Catalog working";
    }
    
    /**
   * Overriden equals() method
     */
     public boolean equals(CourseCatalog catalog)
    {
        if(this.equals(catalog))
        {
            return true;
        }
        return false;
    }
}
