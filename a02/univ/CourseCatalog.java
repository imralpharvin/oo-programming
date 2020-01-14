package univ;

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
     * The addCourse(Course toAdd) method adds a course in the course list
     * @param toAdd course to add
     */
    public void addCourse(Course toAdd)
    {
        courseList.add(toAdd);
    }
    
    /**
     * The removeCourse(Course toRemove) method removes a course in the course list
     * @param toRemove course to remove
     */
    public void removeCourse(Course toRemove)
    {
        courseList.remove(toRemove);
    }
    
    private void setCourseList(ArrayList<Course> courseList)
    {
        this.courseList = courseList;
    }
    
    public ArrayList<Course> getCourseList()
    {
        return this.courseList;
    }
    /**
     * The findCourse() method finds a course in the course list and returns it
     * @param courseCode code of a course
     * @return course list
     */
    public Course findCourse(String courseCode)
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
    
    
}