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

public class Bootstrap
{
   private CourseCatalog allCourses;
   private Degree deg;
   
   public Bootstrap()
   {
       allCourses = new CourseCatalog();
   }
   
    /**
    * This main method is used to start the application.
    */
    public static void main(String args[]) 
    {
        Bootstrap administration = new Bootstrap();
        Scanner sc = new Scanner(System.in);
        //Print welcome screen and prompt user to select option
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        System.out.println("> Welcome to Student Planner!\n");

        String optionMenu = "1" ;
        while(!optionMenu.equals("E"))
        {
            System.out.println("*******************************************");
            System.out.println("> What would you like to do?\n(1) Load Available Courses\n(2) Load required courses of a degree\n\n(S) Save files\n(E) Exit");
            optionMenu = sc.nextLine();
            switch(optionMenu)
            {
                case "1": administration.loadCoursesFile();
                    break;
                case "2": administration.loadRequiredCoursesFile();
                    break;
                case "S": administration.saveFiles();
                    break;
                case "E": System.out.println("*******************************************");
                    System.out.println("> Thank you for using planner!");
                    System.out.println("*******************************************");
                    System.exit(0);
                    break;
                default: System.out.println("Not one of the options! Please input one of the options.");;;
                    break; 
            }

        }
    }
    
    /**
    * The createFileMenu() method prompts user to input file that has all the courses and load it to the application.
    */
    public void loadCoursesFile()
    {
        Scanner sc = new Scanner(System.in);
        CourseCatalog tempCatalog = new CourseCatalog();

        System.out.println("Input course catalog file: ");
        String filename = sc.nextLine();

        tempCatalog.initializeCatalog(filename);
        allCourses = tempCatalog;

    }

    /**
    * The loadRequiredCoursesFile() method prompts user to input file that has all the required courses of a degree.
    */
    public void loadRequiredCoursesFile()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input required courses file: ");
        String filename = sc.nextLine();

        File file = new File(filename);
        String line;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader (file));

            while ((line = br.readLine()) != null) 
            {    
                System.out.println(line);
                String[] words = line.split(",");
                ArrayList<String> requiredCourses = new ArrayList<>(Arrays.asList(words));

                if(requiredCourses.get(0).equals("BCG"))
                {
                    deg = new BCG();
                }

                else if(requiredCourses.get(0).equals("CS"))
                {
                    deg = new CS();
                }

                else if(requiredCourses.get(0).equals("SEng"))
                {
                    deg = new SEng();

                }
                else
                {
                    System.out.println("No such degree in system");
                    return;
                }
                requiredCourses.remove(requiredCourses.get(0));
                deg.setRequiredCourses(requiredCourses);
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
    * The saveFiles() method saves both files created.
    */
    public void saveFiles()
    {
        String filename = null;
        
        allCourses.saveCatalog();
        try
        {
            if(deg instanceof BCG)
            {
                filename = "requiredCoursesBCG.csv";
            }
            else if(deg instanceof CS)
            {
                filename = "requiredCoursesCS.csv";
            }
            else if(deg instanceof SEng)
            {
                filename = "requiredCoursesSEng.csv";
            }
            
            FileWriter file = new FileWriter(filename);

            if(deg instanceof BCG)
            {
                file.append("BCG");
            }
            else if(deg instanceof CS)
            {
                file.append("CS");
            }
            else if(deg instanceof SEng)
            {
                file.append("SEng");
            }

            for(Course course: deg.getRequiredCourses())
            {
                file.append(",");
                file.append(course.getCourseCode());
            }

            file.flush();
            file.close();
        } 

        catch (FileNotFoundException ex)
        {
            System.out.println("No such file1");
        }

        catch (IOException ioex)
        {
            System.out.println("No such file2");
        }
    }
    
   /**
   * Overriden toString() method
   */
    public String toString()
    {
        return "Bootstrap";
    }
    
   /**
   * Overriden equals() method
   */
    public boolean equals(Bootstrap bootstrap)
    {
        if(bootstrap instanceof Bootstrap)
        {
            return true;
        }
        return false;
    }
}
