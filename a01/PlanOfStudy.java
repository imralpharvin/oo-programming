import java.util.ArrayList;
import java.io.*;
/**
* <h1>PlanOfStudy</h1>
* The PlanOfStudy class provides functions/methods for users to organize elements of degree and list of courses taken.
* @author  Ralph Arvin De Castro
* @since October 2018
*/
public class PlanOfStudy implements Serializable
{
    private Degree deg;
    private ArrayList<Course> courses;
    private Student student;
    
    public PlanOfStudy()
    {
        courses = new ArrayList<Course>();
        student = new Student();
    }
    
     /**
   * The setDegreeProgram(Degree deg) method sets the degree program.
   * @param deg Degree class to be set
     */
    void setDegreeProgram(Degree deg)
    {
        this.deg = deg;
    }
   
     /**
   * The getDegreeProgram(Degree deg) method returns the degree program.
   * @return deg Degree class
     */
    Degree getDegreeProgram()
    {
        return this.deg;
    }
    
    /**
   * The importData(String filename) method imports data from a file and set data into respective elements.
   * @param filename file needed to get data
     */
    void importData(String filename)
    {
        File file = new File(filename);
        CourseCatalog allCourses = new CourseCatalog();
        String line;
        
        allCourses.initializeCatalog("allCourses.csv");
        try
        {
             BufferedReader br = new BufferedReader(new FileReader (file));
             
             while ((line = br.readLine()) != null) 
             {    

                 String[] words = line.split(",");
                 
                 Course course = new Course(allCourses.findCourse(words[0]));
                 course.setCourseStatus(words[1]);
                 course.setCourseGrade(words[2]);
                 course.setSemesterTaken(words[3]);
                 this.courses.add(course);
             }
        }
    
        catch (FileNotFoundException ex)
        {
            System.out.println("*******************************************");
            System.out.println("> No such file! Please try again!");
            System.exit(0);
        }
        
        catch (IOException ioex)
        {
            System.out.println("No such file");
            System.exit(0);
        }
        
    }
    
    /**
   * The saveState() method saves the state of the fields into a csv file. Student number will be the primary key.
     */
    void saveState()
    {
         try
      {
          String filename = student.getStudentNumber().toString() + "Transcript.csv";
          System.out.println(filename);
          
          FileWriter file = new FileWriter(filename);
         
              file.append(student.getLastName());
              file.append(",");
              file.append(student.getFirstName());
              file.append(",");
              file.append(student.getStudentNumber().toString());
              file.append(",");
              if(getDegreeProgram() instanceof BCG)
              {
                  file.append("BCG");
                }
                
              else if(getDegreeProgram() instanceof CS)
              {
                  file.append("CS");
                }
              else if(getDegreeProgram() instanceof SEng)
              {
                  file.append("SEng");
                }
              
              file.append("\n");
           for(Course course: getCourseList())
          {
              file.append(course.getCourseCode());
              file.append(",");
              file.append(course.getCourseStatus());
              file.append(",");
              file.append(course.getCourseGrade());
              file.append(",");
              file.append(course.getSemesterTaken());
    
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
   * The addCourse(String courseCode, String semester) method adds course to the study plan.
   * @param courseCode String that has the course code
   * * @param semester String that has the semester taken
     */
    void addCourse(String courseCode, String semester)
    {
        CourseCatalog allCourses = new CourseCatalog();
        allCourses.initializeCatalog("allCourses.csv");
        if(allCourses.findCourse(courseCode) != null)
        {
        Course course = new Course(allCourses.findCourse(courseCode));
        course.setCourseCode(courseCode);
        course.setSemesterTaken(semester);
        courses.add(course);
    }
        else
        {
            System.out.println("*******************************************");
            System.out.println("> No such course (" + courseCode + ") in catalog! Please try again!");
        }
    }
    
    /**
   * The removeCourse(String courseCode, String semester) method removes course from the study plan.
   * @param courseCode String that has the course code
   * * @param semester String that has the semester taken
     */
    void removeCourse(String courseCode, String semester)
    {
        for(int i = 0; i < courses.size();i++)
        {
            if(courseCode.equals(courses.get(i).getCourseCode()) && semester.equals(courses.get(i).getSemesterTaken()))
            {
                courses.remove(courses.get(i));
            }
        }
    }
    
    
    /**
   * The setCourseStatus(String courseCode, String semester, String courseStatus) method sets the status of a course from the list.
   * @param courseCode String that has the course code
   * @param semester String that has the semester taken
    * @param courseStatus String that has the course status
     */
    void setCourseStatus(String courseCode, String semester, String courseStatus)
    {
        for(Course course: courses)
        {
            if(courseCode.equals(course.getCourseCode()) && semester.equals(course.getSemesterTaken()))
            {
                course.setCourseStatus(courseStatus);
            }
        }
    }
    
     /**
   * The setCourseGrade(String courseCode, String semester, String grade) method sets the grade of a course from the list.
   * @param courseCode String that has the course code
   * @param semester String that has the semester taken
    * @param courseGrade String that has the course status
     */
    void setCourseGrade(String courseCode, String semester, String grade)
    {
        for(Course course: courses)
        {
            if(courseCode.equals(course.getCourseCode()) && semester.equals(course.getSemesterTaken()))
            {
                course.setCourseGrade(grade);
            }
        }
    }
    /**
   * The setCourseTyoe(String courseCode, String semester, String type) method sets the grade of a course from the list.
   * @param courseCode String that has the course code
   * @param semester String that has the semester taken
    * @param type String that has the course type
     */
    void setCourseType(String courseCode, String semester, String type)
    {
        for(Course course: courses)
        {
            if(courseCode.equals(course.getCourseCode()) && semester.equals(course.getSemesterTaken()))
            {
                course.setCourseType(type);
            }
        }
    }
    
    /**
   * The getCourse(String courseCode, String semester) method gets a course from the study plan.
   * @param courseCode String that has the course code
   * @param semester String that has the semester taken
     * @return the couse
     */
    Course getCourse(String courseCode, String semester)
    {
        for(Course course: courses)
        {
            if(courseCode.equals(course.getCourseCode()) && semester.equals(course.getSemesterTaken()))
            {
                return course;
            }
        }
        
        return null;
    }
    /**
   * The findCourse(String courseCode, String semester) method finds and return a course from a list of courses.
   * @param courseCode String that has the course code
   * @param semester String that has the semester taken
     * @return the couse
     */
     Course findCourse(ArrayList <Course> courseList,String courseCode)
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
   * The getCourseList() method return the list of courses.
     * @return course list array
     */
    ArrayList<Course> getCourseList()
    {
        return courses;
    }
    
    /**
   * The setStudent(Student student) sets the information of a student.
     * @param student
     */
    void setStudent(Student student)
    {
        this.student = student;
    }
   
     /**
   * The getStudent() method returns the student.
     * @return course list array
     */
    Student getStudent()
    {
        return this.student;
    }

    public String toString()
    {
        return student.toString() + deg.toString();
    }
    
    public boolean equals(PlanOfStudy plan)
    {
        if(student.equals(plan.getStudent()))
        {
            return true;
        }
        return false;
    }
}
