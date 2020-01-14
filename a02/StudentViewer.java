import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import univ.*;

public class StudentViewer extends JFrame
{
    StudentController controller;
    JFrame welcomeMenu;
    JFrame studentForm;
    JFrame loadForm;
    
    public StudentViewer()
    {
        controller = new StudentController();    //Set fields          
        welcomeMenu = new JFrame("Student Planner");
        studentForm = new JFrame("Create Account");
        loadForm = new JFrame("Sign In");
        
        mainMenu();
    }
    
    public static void main(String args[])
    {
        new StudentViewer();        
    }
    
    public void mainMenu()
    {
        //Set Main Jframe 
        getContentPane().setLayout(new BorderLayout());        
        setSize(750,750);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.RED);
        
        //Set Menu
        JMenuBar menuBar = new JMenuBar(); 
        JMenu file = new JMenu("File");
        menuBar.add(file);
        setJMenuBar(menuBar);        
        JMenuItem menuItem = new JMenuItem("Save Student"); //Add menu item
        menuItem.addActionListener(action -> controller.saveStudent());
        file.add(menuItem);
        JMenuItem menuItem2 = new JMenuItem("Close (Back to Main Menu)"); //Add menu item
        menuItem2.addActionListener(action -> welcomeMenu());
        file.add(menuItem2);
        
        //Set North Panel 
        JPanel northPanel = new JPanel(); 
        JLabel label = new JLabel("Welcome to Student Planner");
        northPanel.setBackground(Color.RED);
        northPanel.add(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        
        //Set West Panel
        JPanel westPanel = new JPanel();  //Setting panel
        westPanel.setLayout(new GridLayout(0,1));
        westPanel.setBackground(Color.BLACK);        
        JLabel degreeLabel = new JLabel("Degree"); //Adding label
        degreeLabel.setHorizontalAlignment(JLabel.CENTER);
        degreeLabel.setVerticalAlignment(JLabel.CENTER);
        degreeLabel.setForeground(Color.YELLOW);
        westPanel.add(degreeLabel);        
        JButton selectDegreeAndMajor = new JButton("Select Degree And Major"); //Adding button
        westPanel.add(selectDegreeAndMajor); 
        selectDegreeAndMajor.setBackground(Color.yellow);
        selectDegreeAndMajor.addActionListener(action -> controller.selectDegreeAndMajor());        
        JLabel label2 = new JLabel("Transcript"); //Adding label
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setForeground(Color.YELLOW);
        westPanel.add(label2);
        JButton addCoursetoTranscript = new JButton("Add Course");//Add button
        addCoursetoTranscript.setBackground(Color.yellow);
        addCoursetoTranscript.addActionListener(action -> controller.addCoursetoTranscript());
        westPanel.add(addCoursetoTranscript );
        JButton removeCoursefromTranscript = new JButton("Remove Course"); //Add button
        removeCoursefromTranscript.setBackground(Color.yellow);        
        removeCoursefromTranscript.addActionListener(action -> controller.removeCoursefromTranscript());       
        westPanel.add(removeCoursefromTranscript );
        JButton changeGrade = new JButton("Change Grade"); //Add button
        changeGrade.setBackground(Color.yellow);
        changeGrade.addActionListener(action -> controller.changeGrade());
        westPanel.add(changeGrade );
        JButton viewPrerequisites  = new JButton("View Prerequisites");//Add button
        viewPrerequisites.setBackground(Color.yellow);
        viewPrerequisites.addActionListener(action -> controller.viewPrerequisites());
        westPanel.add(viewPrerequisites );
        JButton viewCurrentCredits  = new JButton("View Current Credits"); //Add button
        viewCurrentCredits.setBackground(Color.yellow);
        viewCurrentCredits.addActionListener(action -> controller.viewCurrentCredits());
        westPanel.add(viewCurrentCredits );        
        JButton getMissingCourses = new JButton("Get Missing Courses");
        getMissingCourses.setBackground(Color.yellow);
        getMissingCourses.addActionListener(action -> controller.showMissingCourses());
        westPanel.add(getMissingCourses );
        JButton viewRemainingCredits  = new JButton("View Remaining Credits");
        viewRemainingCredits.setBackground(Color.yellow);
        viewRemainingCredits.addActionListener(action -> controller.showRemainingCredits());
        westPanel.add(viewRemainingCredits);
        
        //Centre Panel                
        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new GridLayout(0,1));
        centrePanel.setBackground(Color.BLACK);
        DBConnect database = new DBConnect();        
        String theCourses = "List of Courses in Catalog\n\n";
        for(Course course: database.getCourseCatalog().getCourseList()) {
            theCourses = theCourses + course.toString() + "\n";
        }
        JTextArea allCourses = new JTextArea(theCourses);
        allCourses.setEditable(false);
        allCourses.setForeground(Color.YELLOW);
        allCourses.setBackground(Color.BLACK);        
        JScrollPane scroll = new JScrollPane(allCourses);
        centrePanel.add(scroll);
        
        //East Panel//
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(0,1));
        eastPanel.setBackground(Color.BLACK);   
        JLabel planLabel = new JLabel("Course Plan"); //Add label
        planLabel.setHorizontalAlignment(JLabel.CENTER);
        planLabel.setVerticalAlignment(JLabel.CENTER);
        planLabel.setForeground(Color.YELLOW);
        eastPanel.add(planLabel);
        JButton viewCoursePlan = new JButton("View Course Plan");           
        viewCoursePlan.setBackground(Color.yellow);
        viewCoursePlan.addActionListener(action -> controller.showCoursePlan());        
        eastPanel.add(viewCoursePlan);        
        JButton askCompletion = new JButton("View Eligibility to Graduate");           
        askCompletion.setBackground(Color.yellow);
        askCompletion.addActionListener(action -> controller.showGraduationEligibility());        
        eastPanel.add(askCompletion);
        JLabel posLabel = new JLabel("Plan Of Study"); //Add label
        posLabel.setHorizontalAlignment(JLabel.CENTER);
        posLabel.setVerticalAlignment(JLabel.CENTER);
        posLabel.setForeground(Color.YELLOW);
        eastPanel.add(posLabel);                
        JButton addCoursetoPlan = new JButton("Add Course to Plan"); //Add button
        addCoursetoPlan.setBackground(Color.yellow);
        eastPanel.add(addCoursetoPlan);
        addCoursetoPlan.addActionListener(action -> controller.addCoursetoPlan());        
        JButton removeCoursefromPlan = new JButton("Remove Course from Plan"); //Add button
        removeCoursefromPlan.setBackground(Color.yellow);
        eastPanel.add(removeCoursefromPlan);
        removeCoursefromPlan.addActionListener(action -> controller.removeCoursefromPlan());        
        JButton getMissingCoursesPOS = new JButton("Get Missing Courses (POS)");
        getMissingCoursesPOS.setBackground(Color.yellow);
        eastPanel.add(getMissingCoursesPOS);
        getMissingCoursesPOS.addActionListener(action -> controller.showMissingCoursesPOS());        
        JButton viewRemainingCreditsPOS = new JButton("View Remaining Credits (POS)"); //Add button
        viewRemainingCreditsPOS.setBackground(Color.yellow);
        eastPanel.add(viewRemainingCreditsPOS);
        viewRemainingCreditsPOS.addActionListener(action -> controller.showRemainingCreditsPOS());        
        JButton getPrerequisitesPOS = new JButton("View Prequisites (POS)");        
        getPrerequisitesPOS.setBackground(Color.yellow);
        eastPanel.add(getPrerequisitesPOS);
        getPrerequisitesPOS.addActionListener(action -> controller.viewPrerequisites());
                      
        //South Panel
        JPanel southPanel = new JPanel();        
        JButton viewGPA = new JButton("View GPA"); //Add button
        viewGPA.setBackground(Color.yellow);
        southPanel.add(viewGPA);
        viewGPA.addActionListener(action -> controller.showGPA());        
        JButton viewGPAcis = new JButton("View CIS GPA"); 
        viewGPAcis.setBackground(Color.yellow);
        southPanel.add(viewGPAcis);
        viewGPAcis.addActionListener(action -> controller.showGPAcis());
        JButton viewGPA10 = new JButton("View GPA for last 10 credits");
        viewGPA10.setBackground(Color.yellow); viewGPA10.addActionListener(action -> controller.showGPAcis());
        southPanel.add(viewGPA10);
       
        //Add panels
        add(northPanel, BorderLayout.NORTH);
        add(westPanel, BorderLayout.WEST);
        add(centrePanel, BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);
        
        welcomeMenu();
    }
    
    public void welcomeMenu()
    {              
        dispose();
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayout(0,1));
        welcomePanel.setBackground(Color.BLACK);
                       
        JLabel welcomeLabel = new JLabel("Welcome to Student Planner!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(Color.YELLOW);
        welcomePanel.add(welcomeLabel);
        
        JButton newStudent = new JButton(); //Add button
        newStudent.setBackground(Color.RED);
        newStudent.setText("New Student");
        newStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                studentMenu();
                welcomeMenu.dispose();
                studentForm.setVisible(true);
            }});
        welcomePanel.add(newStudent);
          
        JButton loadStudent = new JButton(); //Add button
        loadStudent.setText("Existing Student");
        loadStudent.setBackground(Color.RED);
        loadStudent.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e) 
            {
                loadMenu();
                welcomeMenu.dispose();
                loadForm.setVisible(true);
            }});
        welcomePanel.add(loadStudent);

        welcomeMenu.add(welcomePanel);
        welcomeMenu.setSize(300, 300);
        welcomeMenu.setLocationRelativeTo(null);
        welcomeMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeMenu.setVisible(true);
               
    }
    
    public void studentMenu()
    {
        
        studentForm.setSize(400, 400);
        studentForm.setLocationRelativeTo(null);
        studentForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        JPanel studentPanel = new JPanel();
        studentPanel.setBackground(Color.YELLOW);
        studentPanel.setLayout(null);

        JLabel fName = new JLabel("Enter First Name");
        fName.setBounds(100,25,200,30); 
        studentPanel.add(fName);
        
        JTextField firstName = new JTextField();
        firstName.setBounds(100,50,200,30); 
        studentPanel.add(firstName);        
        
        JLabel lName = new JLabel("Enter Last Name");
        lName.setBounds(100,75,200,30); 
        studentPanel.add(lName);
        
        JTextField lastName = new JTextField();
        lastName.setBounds(100,100,200,30); 
        studentPanel.add(lastName);
                
        JLabel sNum = new JLabel("Enter Student Number");
        sNum.setBounds(100,125,200,30); 
        studentPanel.add(sNum);
                
        JTextField studentNumber = new JTextField();
        studentNumber.setBounds(100,150,200,30); 
        studentPanel.add(studentNumber);
        
        JButton button = new JButton();
        button.setText("Create Student");
        button.setBounds(100, 250, 200, 30);
        class StudentCreate implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                String sfName = firstName.getText();
                String slName = lastName.getText();
                String ssNum = studentNumber.getText();
                Integer isNum = 0;
                
                try{
                     isNum = Integer.valueOf(ssNum);
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Your student number is not an integer. Please put a valid output!");
                    return;
                }
                
                try{
                    if(sfName.equals("") || slName.equals("") ){
                        throw new EmptyFieldException();
                               
                    }
                    else{
                
                        controller.createStudent(sfName, slName, isNum);
                        
                        String[] degrees  = {"B.Comp. General", "B.Comp. Honours: Computer Science", "B.Comp. Honours: Software Engineering"};
                        String degree = null;
                        while(degree == null) {
                            degree = (String) JOptionPane.showInputDialog(studentForm, "Choose Degree and Major","Select Degree And Major",JOptionPane.PLAIN_MESSAGE, null, degrees, degrees[0]);
                            if(degree != null){
                                controller.model.selectDegreeAndMajor(degree);
                            }
                            
                        }                    
                        studentForm.dispose();
                        setVisible(true);
                    }
                
                }
                catch (EmptyFieldException f){
                     JOptionPane.showMessageDialog(null, "Please fill all the values!");  
                }              
            }
        }
        button.addActionListener(new StudentCreate());
        studentPanel.add(button);
        studentForm.add(studentPanel);
    }
    
    public void loadMenu()
    {
        loadForm.setSize(400, 400);
        loadForm.setLocationRelativeTo(null);
        loadForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        

        JPanel loadPanel = new JPanel();
        loadPanel.setBackground(Color.YELLOW);
        loadPanel.setLayout(null);

        JLabel fName = new JLabel("Enter First Name");
        fName.setBounds(100,25,200,30); 
        loadPanel.add(fName);
        
        JTextField firstName = new JTextField();
        firstName.setBounds(100,50,200,30); 
        loadPanel.add(firstName);
                
        JLabel lName = new JLabel("Enter Last Name");
        lName.setBounds(100,75,200,30); 
        loadPanel.add(lName);
        
        JTextField lastName = new JTextField();
        lastName.setBounds(100,100,200,30); 
        loadPanel.add(lastName);
                
        JLabel sNum = new JLabel("Enter Student Number");
        sNum.setBounds(100,125,200,30); 
        loadPanel.add(sNum);
                
        JTextField studentNumber = new JTextField();
        studentNumber.setBounds(100,150,200,30); 
        loadPanel.add(studentNumber);        
        
        JButton button = new JButton();
        button.setText("Log In");
        button.setBounds(100, 250, 200, 30);        
        class StudentLoad implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                String sfName = firstName.getText();
                String slName = lastName.getText();
                String ssNum = studentNumber.getText();
                Integer isNum = 0;
                try{
                    isNum = Integer.valueOf(ssNum);
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Your student number is not an integer. Please put a valid output!");
                    return;
                }
                
                String fullName = slName + "," + sfName;
                
                DBConnect database = new DBConnect();
                DBStudent dbStudent = database.getDBStudent(String.valueOf(isNum),fullName);
                
                try{
                    
                    if(dbStudent.getId() == null ){
                       throw new NoStudentException();
                    }      
                    else{
                        controller.createStudent(sfName, slName, isNum);
                        controller.model.selectDegreeAndMajor(dbStudent.getDegree());
                        for(String course: dbStudent.getCourses()) {
                            String[] info = course.split(",");
                            
                            if(info[0].equals("A")){
                            Course courseadd = database.getCourseCatalog().findCourse(info[1]);
                            controller.model.getStudent().getTranscript().addAttempt(courseadd, info[2], info[3]);
                            }
                            else if(info[0].equals("P")){
                            Course courseadd = database.getCourseCatalog().findCourse(info[1]);
                            controller.model.getStudent().getPlanOfStudy().addCoursetoPlan(courseadd, info[2]);
                            }
                            
                        }
                        loadForm.dispose();
                        setVisible(true);
                    }
                }
                catch(NoStudentException n){
                    JOptionPane.showMessageDialog(null, "No such account in the system! Please try again");
                }
                
            }
        }
        
        button.addActionListener(new StudentLoad());
      
        loadPanel.add(button);
        loadForm.add(loadPanel);        
    }   
}
