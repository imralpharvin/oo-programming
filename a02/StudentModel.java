import univ.*;

import java.util.*;

public class StudentModel
{
    private Student student;
    
    public StudentModel()
    {
        student = new Student();
    }

    private void setStudent(Student student)
    {
        this.student = student;
    }
    
    public Student getStudent()
    {
        return this.student;
    }
    
    public void setStudentInfo(String fname, String lname, Integer snumber)
    {
        Student student = new Student(fname, lname, snumber);
        setStudent(student);
    }
    public void selectDegreeAndMajor(String degree)
    {
        switch(degree){
            case "B.Comp. General": student.setDegreeProgram(new BCG());
                break;
            case "B.Comp. Honours: Computer Science": student.setDegreeProgram(new CS());
                break;
            case "B.Comp. Honours: Software Engineering": student.setDegreeProgram(new SEng());
                break;
            default: student.setDegreeProgram(null);
                break;
            
        }
    }
    
    public void addCoursetoPlan(Course course, String semester)
    {
        student.getPlanOfStudy().addCoursetoPlan(course, semester);
    }
    
    public void removeCoursefromPlan(Course course, String semester)
    {
        student.getPlanOfStudy().removeCoursefromPlan(course, semester);
    }
    
    public void addCourseInTranscript(Course course, String semester, String grade)
    {      
        student.getTranscript().addAttempt(course, semester, grade);
    }
    
    public void removeCourseInTranscript(String code, String semester)
    {
        student.getTranscript().removeAttempt(code, semester);
    }
    
    public void changeGrade(String code, String semester, String grade)
    {
        student.getTranscript().changeGrade(code, semester, grade);
    }
    
    public ArrayList<Course> getPrerequisites(String code)
    {
        DBConnect database = new DBConnect();
        Course course = database.getCourseCatalog().findCourse(code);

        return course.getPrerequisites();
    }
    
    public String getCurrentCredits()
    {
        ArrayList<Attempt> attempts = new ArrayList<>();
        attempts = student.getTranscript().getAttempts();  
        double totalCredits = 0;
        
        for(Attempt attempt: attempts)  {
            totalCredits = totalCredits + attempt.getCourseAttempted().getCourseCredit();
        }
        
        return String.valueOf(totalCredits);
    }
    
    public String getGPA()
    {
        ArrayList<Attempt> attempts = new ArrayList<>();
        attempts = student.getTranscript().getAttempts();  
        double totalCredits = Double.valueOf(getCurrentCredits());
        double totalMarks = 0;
        for(Attempt attempt: attempts) {
            try{
                totalMarks = totalMarks + attempt.getCourseAttempted().getCourseCredit() * Double.valueOf(attempt.getAttemptGrade());
            }
            catch(NumberFormatException e){
                totalCredits -= attempt.getCourseAttempted().getCourseCredit();
            }   
        }
               
        
        if(totalCredits == 0)
        {
            return "0";
        }
        return String.valueOf(totalMarks/totalCredits);
    }
    
    public String getGPAcis()
    {
        ArrayList<Attempt> attempts = new ArrayList<>();
        attempts = student.getTranscript().getAttempts();  
        double totalCisCredits = 0;
        double totalCisMarks = 0;
        
        for(Attempt attempt: attempts)
        {
            String[] keys = attempt.getCourseAttempted().getCourseCode().split("\\*");
             if(keys[0].equals("CIS")) {
                try{
                    totalCisMarks = totalCisMarks + attempt.getCourseAttempted().getCourseCredit() * Double.valueOf(attempt.getAttemptGrade());   
 
                    totalCisCredits = totalCisCredits + attempt.getCourseAttempted().getCourseCredit();
                }
                catch(NumberFormatException e){
                    //don't add
                }   
                 
             }
        }

        if(totalCisCredits == 0)
        {
            return "0";
        }
        
        return String.valueOf(totalCisMarks/totalCisCredits);
    }
    //public void 
    
    public ArrayList<Course> getAllTheCoursesPlannedAndTaken()
    {
        ArrayList<Course> allTheCoursesPlannedAndTaken = new ArrayList<Course>();
        
        for(Attempt attempt: student.getTranscript().getAttempts())  {
            allTheCoursesPlannedAndTaken.add(attempt.getCourseAttempted());
        }
        
        for(Planned planned: student.getPlanOfStudy().getCoursesPlanned()){
            allTheCoursesPlannedAndTaken.add(planned.getCoursePlanned());
        }
        return allTheCoursesPlannedAndTaken;
    }
    
    public ArrayList<Course> getAllTheCoursesTaken()
    {
        ArrayList<Course> allTheCoursesTaken = new ArrayList<Course>();
        
        for(Attempt attempt: student.getTranscript().getAttempts()) {
            allTheCoursesTaken.add(attempt.getCourseAttempted());
        }
        
        return allTheCoursesTaken;
    }
    
    public ArrayList<Course> getMissingCoursesPOS() 
    {
        return student.getDegreeProgram().remainingRequiredCourses(getAllTheCoursesPlannedAndTaken());
        
    }
    
    public ArrayList<Course> getMissingCourses() 
    {
        return student.getDegreeProgram().remainingRequiredCourses(getAllTheCoursesTaken());
        
    }
    
    public double getRemainingCreditsPOS() 
    {
        return student.getDegreeProgram().numberOfCreditsRemaining(getAllTheCoursesPlannedAndTaken());
        
    }
    
    public double getRemainingCredits() 
    {
        return student.getDegreeProgram().numberOfCreditsRemaining(getAllTheCoursesTaken());
        
    }
    
    public void saveStudent() 
    {
       ArrayList<String> allCourses = new ArrayList<String>();
       
       for(Attempt attempt: student.getTranscript().getAttempts()) {
           String toPut = "A," + attempt.toString();
           
           allCourses.add(toPut);
       }
        
       for(Planned planned: student.getPlanOfStudy().getCoursesPlanned())  {
           String toAdd = "P," + planned.toString();
           allCourses.add(toAdd);
           
           }
       
       DBStudent dbstudent = new DBStudent(String.valueOf(student.getStudentNumber()),student.toString(),student.getDegreeProgram().getDegreeTitle(), allCourses );
       DBConnect database = new DBConnect();
       
       database.deleteSavedStudent(String.valueOf(student.getStudentNumber()), student.toString());
       database.saveStudent(dbstudent);
    }
    
    public boolean getGraduationEligibility()
    {
        if(student.getDegreeProgram().meetsRequirements(getAllTheCoursesPlannedAndTaken())) {
            return true;
        }
        return false;
    }
}
