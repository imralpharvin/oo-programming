import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import univ.*;

public class StudentController
{
    public StudentModel model;
    
    public StudentController()
    {
        model = new StudentModel();
    }
    
    public void createStudent(String fname, String lname, Integer sNumber)
    {
       model.setStudentInfo(fname, lname, sNumber);
    }
    
    public void selectDegreeAndMajor()
    {
        String[] degrees  = {"B.Comp. General", "B.Comp. Honours: Computer Science", "B.Comp. Honours: Software Engineering"};
        String degree = null;
        while(degree == null) {
            try{
            
                degree = (String) JOptionPane.showInputDialog(null, "Choose Degree and Major","Select Degree And Major",JOptionPane.PLAIN_MESSAGE, null, degrees, degrees[0]); 
            }
            catch(NullPointerException e)
            {
                JOptionPane.showMessageDialog(null,"Empty degree!"  );
            }
        
        }
        model.selectDegreeAndMajor(degree);
    }
    
    public void addCoursetoPlan()
    {
        String code = null;
        String semester = null;
        
        code = JOptionPane.showInputDialog(null, "Enter Course Code");
        DBConnect database = new DBConnect();
        if(database.getCourseCatalog().findCourse(code) == null){ //If course not in database
            JOptionPane.showMessageDialog(null,"Course not in database! Please view list in main menu."  );
            return;
        }    
        Course course = database.getCourseCatalog().findCourse(code) ;
       
        semester = JOptionPane.showInputDialog(null, "Enter Semester");
        if(semester == null){
            return;
        }
        
        model.addCoursetoPlan(course, semester);
    }
    
    public void removeCoursefromPlan()
    {
        String code = null;
        String semester = null;
        
        code = JOptionPane.showInputDialog(null, "Enter Course Code");
        DBConnect database = new DBConnect();
        if(database.getCourseCatalog().findCourse(code) == null){ //If course not in database
            JOptionPane.showMessageDialog(null,"Course not in database! Please view list in main menu."  );
            return;
        }    
        Course course = database.getCourseCatalog().findCourse(code) ;
        
        semester = JOptionPane.showInputDialog(null, "Enter Semester");
        if(semester == null){
            return;
        }
        
        model.removeCoursefromPlan(course, semester);
    }
    
    public void addCoursetoTranscript()
    {
        String code = JOptionPane.showInputDialog(null, "Enter Course Code");        
     
        if(code == null) { //If student cancels
            return;
        }
                
        DBConnect database = new DBConnect();
        if(database.getCourseCatalog().findCourse(code) == null){ //If course not in database
            JOptionPane.showMessageDialog(null,"Course not in database! Please view list in main menu."  );
            return;
        }        
        
        Course course  = database.getCourseCatalog().findCourse(code);
               
        String semester = JOptionPane.showInputDialog(null, "Enter Semester");
        if(semester == null) { //If student cancels
            return;
        }
        
        String grade = JOptionPane.showInputDialog(null, "Enter Grade");
        if(grade == null) { //If student cancels
            return;
        }
                        
        model.addCourseInTranscript(course, semester, grade);
    }
    
    public void removeCoursefromTranscript()
    {
        String code = JOptionPane.showInputDialog(null, "Enter Course Code");
        if(code == null) { //If student cancels
            return;
        }
                
        DBConnect database = new DBConnect();
        if(database.getCourseCatalog().findCourse(code) == null){ //If course not in database
            JOptionPane.showMessageDialog(null,"Course not in database! Please view list in main menu."  );
            return;
        }      
        
        String semester = JOptionPane.showInputDialog(null, "Enter Semester");
        if(semester == null) { //If student cancels
            return;
        }
        model.removeCourseInTranscript(code, semester);      
    }
    
    public void changeGrade()
    {
        String code = JOptionPane.showInputDialog(null, "Enter Course Code");
        if(code == null) { //If student cancels
            return;
        }
        String semester = JOptionPane.showInputDialog(null, "Enter Semester");
        if(semester == null) { //If student cancels
            return;
        }
        String grade = JOptionPane.showInputDialog(null, "Enter New Grade");
        if(grade == null) { //If student cancels
            return;
        }
        model.changeGrade(code, semester, grade);     
    }
    
    public void viewPrerequisites()
    {
        String code = JOptionPane.showInputDialog(null, "Enter Course Code");
        
        if(code == null) { //If student cancels
            return;
        }
                
        DBConnect database = new DBConnect();
        if(database.getCourseCatalog().findCourse(code) == null){ //If course not in database
            JOptionPane.showMessageDialog(null,"Course not in database! Please view list in main menu."  );
            return;
        }       
        ArrayList<Course> preReq = new ArrayList<>();
        ArrayList<String> codes = new ArrayList<>();
        preReq = model.getPrerequisites(code);
        

        for(Course course: preReq) {
            codes.add(course.getCourseCode());
        }
        
        String courses = "The prerequisites are ";
        for(String string: codes) {
            courses = courses + string + ", "; 
        }
        
        courses = courses + ".";
        
        JOptionPane.showMessageDialog(null,courses);
    }
        
    
    public void viewCurrentCredits()
    {
        JOptionPane.showMessageDialog(null,"Your current number of credits is " + model.getCurrentCredits()  );
        
    }
    
    public void showGPA()
    {
        JOptionPane.showMessageDialog(null,"Your GPA is " + model.getGPA()  );
        
    }
    
    public void showGPAcis()
    {
        JOptionPane.showMessageDialog(null,"Your GPA is " + model.getGPAcis()  );
        
    }
    
    public void showMissingCoursesPOS()
    {
        ArrayList<Course> missingCoursesPOS = new ArrayList<>();
        ArrayList<String> codes = new ArrayList<>();
        missingCoursesPOS = model.getMissingCoursesPOS();
        

        for(Course course: missingCoursesPOS) {
            codes.add(course.getCourseCode());
        }
        
        String courses = "Your missing required courses are ";
        for(String string: codes) {
            courses = courses + string + ", "; 
        }
        
        courses = courses + ".";
        
        JOptionPane.showMessageDialog(null,courses);
        
    }
    
    public void showMissingCourses()
    {
        ArrayList<Course> missingCourses = new ArrayList<>();
        ArrayList<String> codes = new ArrayList<>();
        missingCourses = model.getMissingCourses();
        
        if(missingCourses != null){
            for(Course course: missingCourses){
                codes.add(course.getCourseCode());
            }
    }
        String courses = "Your missing required courses are ";
        for(String string: codes){
            courses = courses + string + ", "; 
        }
        
        courses = courses + ".";
        
        JOptionPane.showMessageDialog(null,courses);
        
    }
    
    public void showRemainingCreditsPOS()
    {
        JOptionPane.showMessageDialog(null,"The number of credits you still have to complete including plan is " + model.getRemainingCreditsPOS()  );
        
    }
    
    public void showRemainingCredits()
    {
        
        JOptionPane.showMessageDialog(null,"The number of credits you still have to complete including plan is " + model.getRemainingCredits()  );
        
    }
    
    public void saveStudent()
    {
        
        model.saveStudent();
        
    }
    
    public void showGraduationEligibility()
    {
        if(model.getGraduationEligibility() == true)
        {
             JOptionPane.showMessageDialog(null,"You are eligible for graduation." );
       
        }
        else
        {
             JOptionPane.showMessageDialog(null,"You are not eligible for graduation yet." );
       
        }
    }
    
    public void showCoursePlan()
    {
        JFrame coursePlan = new JFrame("Course Plan");
        coursePlan.setSize(350,350);
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(0,1));
        panel3.setBackground(Color.BLACK);
        
        String theCourses = "Course Plan\n\nAttempts\n";
        for(Attempt attempt: model.getStudent().getTranscript().getAttempts())   {
            theCourses += attempt.toString() + "\n";
        }
        
        theCourses += "\nPlanned Courses\n";
        for(Planned planned: model.getStudent().getPlanOfStudy().getCoursesPlanned()) {
            theCourses = theCourses + planned.toString() + "\n";
        }
        
        JTextArea allCourses = new JTextArea(theCourses);
        allCourses.setEditable(false);
        allCourses.setForeground(Color.YELLOW);
        allCourses.setBackground(Color.BLACK);
        
        JScrollPane scroll = new JScrollPane(allCourses);
        panel3.add(scroll);
        coursePlan.add(panel3);
        coursePlan.setVisible(true);
    }


}
