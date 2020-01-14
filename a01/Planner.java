import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
* <h1>Planner</h1>
* The Planner application provides functions/methods for CIS students to organize courses and provide degree information.
*
* @author  Ralph Arvin De Castro
* @since October 2018
*/

public class Planner
{
    private PlanOfStudy studentPlan;

    public Planner()
    {
        studentPlan = new PlanOfStudy();
    }

    /**
    * This main method is used to start the application.
    */
    public static void main(String args[]) 
    {
        //Create planner and scanner object
        Planner studentPlanner = new Planner();
        Scanner sc = new Scanner(System.in);

        //Print welcome screen and prompt user to select option
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        System.out.println("> Welcome to Student Planner!\n\n> What would you like to do?\n(1) Create Study Plan\n(2) Load Study Plan");
        String welcomeMenu = "0";
        
        while(!(welcomeMenu.equals("1") || welcomeMenu.equals("2")))
        {
            welcomeMenu = sc.nextLine();
            switch(welcomeMenu)
            {
                case "1": studentPlanner.createFileMenu(); //Creates new file
                    break;
                case "2": studentPlanner.loadPlanofStudy(); //Loads file
                    break;
                default:    System.out.println("*******************************************"); 
                    System.out.println("> Not one of the options! Please input one of the options.");
                    System.out.println("(1) Create Study Plan\n(2) Load Study Plan");
            }
        }    

        //Prints menu for functions and prompt user to select a function to use
        String optionMenu = "1" ;
        while(!optionMenu.equals("E"))
        {
            System.out.println("*******************************************");
            System.out.println("> What would you like to do?\n(1) Add Course\n(2) Remove Course\n(3) Set Course Type\n(4) Set Course Grade\n(5) View Remaining Courses\n(6) View Prerequisites of a course\n(7) View number of credits completed\n(8) View number of credits remaining\n(9) View eligbility to graduate\n\n(C) Change Degree\n(S) Save File\n(E) Exit");
            optionMenu = sc.nextLine();
            switch(optionMenu)
            {
                case "1": studentPlanner.addCourse();
                    break;
                case "2": studentPlanner.removeCourse();
                    break;
                case "3": studentPlanner.markCourseType();
                    break;
                case "4": studentPlanner.changeGrade();
                    break;    
                case "5": studentPlanner.getMissingCourses();
                    break;
                case "6": studentPlanner.getPrerequisites();
                    break;
                case "7": studentPlanner.viewCurrentCredits();
                    break;
                case "8": studentPlanner.viewRemainingCredits();
                    break;
                case "9": studentPlanner.askCompletion();
                    break;
                case "C": studentPlanner.selectDegreeAndMajor();
                    break;
                case "S": studentPlanner.savePlanOfStudy();
                    break; 
                case "E": System.out.println("*******************************************");
                    System.out.println("> Thank you for using planner!");
                    System.out.println("*******************************************");
                    System.exit(0);
                    break;
                default: 
                    System.out.println("*******************************************");
                    System.out.println("Not one of the options! Please input one of the options.");
                    break; 
            }
        }
    }

    /**
    * The createFileMenu() method prompts user to input student (name, number, transcript file) and degree information used to create a file.
    */
    public void createFileMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************************************");
        System.out.println("> Enter first name (required):");
        String firstName = sc.nextLine();
        
        System.out.println("> Enter last name (required):");
        String lastName = sc.nextLine();
       
        System.out.println("> Enter student number (required):");
        String studentNumber = sc.nextLine();
        while(studentPlan.getStudent().isNumeric(studentNumber) == false)
        {
            System.out.println("*******************************************");
            System.out.println("> Not an integer! Please try again!");
            System.out.println("> Enter student number (required):");
            studentNumber = sc.nextLine();
        }
        Integer studentNum = Integer.valueOf(studentNumber);    
        
        Student student = new Student(firstName, lastName, studentNum);
        studentPlan.setStudent(student);
        System.out.println("> Enter student transcript CSV file (optional): ");
        System.out.println("Note: File must be in accordance with the rules.");
        System.out.println("(0) No file");
        String filename = sc.nextLine();
        if(!filename.equals("0"))
        {
            studentPlan.importData(filename);
        }
        selectDegreeAndMajor();

    }

    /**
    * The selectDegreeAndMajor() method prompts user to select degree (BCG, CS, SEng) and loads required courses.
    */
    public void selectDegreeAndMajor()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("> Select Degree:\n(1) B.Comp. General\n(2) B.Comp. Honours: Computer Science\n(3) B.Comp. Honours: Software Engineering");
        String degreeName = sc.nextLine();

        switch(degreeName)
        {
            case "1": loadRequiredCoursesFile("requiredCoursesBCG.csv");
                break;
            case "2": loadRequiredCoursesFile("requiredCoursesCS.csv");
                break;
            case "3": loadRequiredCoursesFile("requiredCoursesSEng.csv");
                break;
        }
    }

    /**
    * The addCourse() method lets user to add a course.
    */
    public void addCourse()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("> Enter course code: ");
        String code = sc.nextLine();
        System.out.println("> Enter semester taken: ");
        String semester = sc.nextLine();
        System.out.println("> Select course status:\n(1) Completed\n(2) In Progress\n(3) Planned ");
        String status = sc.nextLine();
        
        switch(status)
        {   
            case"1": status = "Completed";
                break;
            case"2": status = "In Progress";
                break;
            case"3": status = "Planned";
                break;
        }  
        
        studentPlan.addCourse(code, semester);
        studentPlan.setCourseStatus(code, semester, status);
    }

    /**
    * The markCourseType() method lets user to mark a course as required, elective or minor.
    */
    public void markCourseType()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nYour Courses:");
        for(Course course: studentPlan.getCourseList())
        {
            System.out.println(course.getCourseCode() +" "+ course.getSemesterTaken() );
        }
        System.out.println("> Enter course code: ");
        String code = sc.nextLine();
        System.out.println("> Enter semester taken: ");
        String semester = sc.nextLine();
        System.out.println("> Select course as required, elective or minor:\n(1)Required\n(2)Elective\n(3)Minor");
        String option = sc.nextLine();        
        String status = null;
        switch(option)
        {
            case"1": status = "Required";
            break;
            case"2": status = "Elective";
            break;
            case"3": status = "Minor";
            break;
        }
        studentPlan.setCourseType(code, semester, status);
    }

    /**
    * The removeCourse() method lets user to remove a course from study plan.
    */
    public void removeCourse()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nYour Courses:");
        for(Course course: studentPlan.getCourseList())
        {
            System.out.println(course.getCourseCode() +" "+ course.getSemesterTaken() );
        }
        System.out.println("Enter course code to remove: ");
        String code = sc.nextLine();
        System.out.println("Enter semester taken: ");
        String semester = sc.nextLine();

        studentPlan.removeCourse(code,semester);
    }

    /**
    * The changeGrade() method lets user change the grade of a course from study plan.
    */
    public void changeGrade()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nYour Completed Courses:");
        for(Course course: studentPlan.getCourseList())
        {
            if(course.getCourseStatus().equals("Completed"))
            {
                System.out.println(course.getCourseCode() +" "+ course.getSemesterTaken() );
            }
        }
        System.out.println("> Enter course code to change grade: ");
        String code = sc.nextLine();
        System.out.println("> Enter semester taken: ");
        String semester = sc.nextLine();
        System.out.println("> Enter grade: ");
        String grade = sc.nextLine();

        studentPlan.setCourseGrade(code, semester, grade);

    }

    /**
    * The savePlanOfStudy() method lets user save the information provided in this application in a csv file..
    */
    public void savePlanOfStudy()
    {
        String filename = studentPlan.getStudent().getStudentNumber().toString() + "Transcript.ser";
        //studentPlan.saveState();
        
        try 
        {            
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentPlan);
            oos.close();
        } 
        catch (FileNotFoundException e) 
        {        
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
    
    }

    /**
    * The loadPlanofStudy() method lets user load a file created by application. It asks for student number as primary key.
    */
    public void loadPlanofStudy()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student number:");
        String studentNumber = sc.nextLine();
        Integer studentNum = Integer.valueOf(studentNumber);    

        String filename = studentNum.toString() + "Transcript.ser";
        File file = new File(filename);
        
        try 
        {
            FileInputStream fi = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fi);
            studentPlan = (PlanOfStudy) oi.readObject();
            oi.close();
        } 
        catch (FileNotFoundException e) 
        {
                System.out.println("> No such file! Please create a file first!");
                e.printStackTrace();
                createFileMenu();           
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    /**
    * The getMissingCourses() method allows user to view required courses that has not been completed yet.
    */
    public void getMissingCourses()
    {        
        Scanner sc = new Scanner(System.in);
        ArrayList<Course> remainingCourses = new ArrayList<>();           
        remainingCourses = studentPlan.getDegreeProgram().remainingRequiredCourses(studentPlan);
        
        System.out.println("*******************************************");
        System.out.println("Remaining required courses for " + studentPlan.getDegreeProgram().toString()+":");
        for(Course course: studentPlan.getDegreeProgram().remainingRequiredCourses(studentPlan))
        {
            System.out.println(course.toString());
        }
        System.out.println("> Press any key and enter to continue" );
        sc.nextLine();
    }

    /**
    * The getPrerequisites() method allows user to view prerequisites of a course.
    */
    public void getPrerequisites()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("> Enter course code to find prerequisites: ");
        String code = sc.nextLine();
        ArrayList<Course> preReqs = new ArrayList<>();
        CourseCatalog allCourses = new CourseCatalog();
        allCourses.initializeCatalog("allCourses.csv");
        
        while(studentPlan.findCourse(allCourses.getCourseList(),code) == null)
        {
            System.out.println("*******************************************");
            System.out.println("> No such course! Please try again.");
            System.out.println("> Enter course code to find prerequisites: ");
            code = sc.nextLine();
        }

        preReqs = studentPlan.findCourse(allCourses.getCourseList(),code).getPrerequisites();

        if(preReqs == null)
        {
            System.out.println("*******************************************");
            System.out.println("No prerequisites for " + code);
            return;
        }
        System.out.println("*******************************************");
        System.out.println("> Prerequisites for " + code + ":" );
        for(Course course: preReqs)
        {
            System.out.println(course.toString());
        }
        System.out.println("> Press any key and enter to continue" );
        sc.nextLine();

    }
    
    /**
    * The viewCurrentCredits() method allows user to view number of completed credits.
    */
    public void viewCurrentCredits()
    {        
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************************************");
        System.out.println("You currently have " + studentPlan.getDegreeProgram().numberOfCurrentCredits(studentPlan) + " credits." );
        System.out.println("> Press any key and enter to continue" );
        sc.nextLine();
    }

    /**
    * The viewRemainingCredits() method allows user to view number of remaining credits needed to be completed.
    */
    public void viewRemainingCredits()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************************************");
        System.out.println("You still have " + studentPlan.getDegreeProgram().numberOfCreditsRemaining(studentPlan) + " credits to complete." );
        System.out.println("> Press any key and enter to continue" );
        sc.nextLine();
    }

    /**
    * The viewRemainingCredits() method allows user to determine if they follow all the requirements of the degree selected.
    */
    public void askCompletion()
    {
        Scanner sc = new Scanner(System.in);
        boolean graduate = false;
        if(studentPlan.getDegreeProgram() instanceof BCG)
        {
            graduate = ((BCG)studentPlan.getDegreeProgram()).meetsRequirements(studentPlan);
        }
        else if(studentPlan.getDegreeProgram() instanceof CS)
        {
            graduate = ((CS)studentPlan.getDegreeProgram()).meetsRequirements(studentPlan);
        }
        else if(studentPlan.getDegreeProgram() instanceof SEng)
        {
            graduate = ((SEng)studentPlan.getDegreeProgram()).meetsRequirements(studentPlan);
        }
        System.out.println("*******************************************");
        if(graduate == true)
        {
            System.out.println("> You have completed the requirements for " + studentPlan.getDegreeProgram().toString());

        }
        else
        {
            System.out.println("> You still have requirements to complete for " + studentPlan.getDegreeProgram().toString());
            System.out.println("Please check requirements online or with a counsellor.");

        }
        System.out.println("> Press any key and enter to continue" );
        sc.nextLine();

    }

    /**
    * The loadRequiredCoursesFile(String filename) helper method loads required courses into the degree selected.
    * @param filename file that includes required courses of a degree
    */
    public void loadRequiredCoursesFile(String filename)
    {
        File file = new File(filename);
        String line;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader (file));

            while ((line = br.readLine()) != null) 
            {    
            String[] words = line.split(",");
            ArrayList<String> requiredCourses = new ArrayList<>(Arrays.asList(words));

            if(requiredCourses.get(0).equals("BCG"))
            {
                studentPlan.setDegreeProgram(new BCG());
            }

            else if(requiredCourses.get(0).equals("CS"))
            {
                studentPlan.setDegreeProgram(new CS());
            }

            else if(requiredCourses.get(0).equals("SEng"))
            {
                studentPlan.setDegreeProgram(new SEng());
            }
            else
            {
                System.out.println("No such degree in system");
                return;
            }
            requiredCourses.remove(requiredCourses.get(0));
            studentPlan.getDegreeProgram().setRequiredCourses(requiredCourses);

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
   * Overriden toString() method
   */
    public String toString()
    {
        return studentPlan.toString();
    }
    
   /**
   * Overriden equals() method
   */
    public boolean equals(Planner plan)
    {
        if(plan instanceof Planner)
        {
            return true;
        }
        return false;
    }
}
