import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AdministratorViewer extends JFrame
{
    AdministratorController controller;
   
    public AdministratorViewer()
    {      
        controller = new AdministratorController();
        showMenu();
    }
    
    public static void main(String args[])
    {
        new AdministratorViewer();        
    }
    
    public void showMenu()
    {
        getContentPane().setLayout(new GridLayout(0,1));
        setSize(300,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        
        //Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        menuBar.add(file);
        setJMenuBar(menuBar);
        
        JMenuItem menuItem = new JMenuItem("Save Catalog");
        menuItem.addActionListener(action -> controller.saveCatalog());
        file.add(menuItem);
               
        //North Panel
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0,1));
        panel1.setBackground(Color.BLACK);
               
        JLabel label = new JLabel("Welcome to Administrator");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(Color.YELLOW);
        panel1.add(label);
        
        JLabel label1 = new JLabel("Course Catalog");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setForeground(Color.YELLOW);
        panel1.add(label1);
        
        JButton addCourse = new JButton("Add Course to Catalog"); //Adding button
        addCourse.setBackground(Color.yellow);
        panel1.add(addCourse); 
        addCourse.addActionListener(action -> controller.addCoursetoCatalog());
        
        JButton removeCourse = new JButton("Remove Course from Catalog"); //Adding button
        removeCourse.setBackground(Color.yellow);
        panel1.add(removeCourse); 
        removeCourse.addActionListener(action -> controller.removeCoursefromCatalog());
       
        add(panel1);
        setVisible(true);
    }
}
