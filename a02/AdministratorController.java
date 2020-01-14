import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import univ.*;


public class AdministratorController
{
    AdministratorModel model;


    public AdministratorController()
    {
        model = new AdministratorModel();
    }


    public void addCoursetoCatalog()
    {
        String code = JOptionPane.showInputDialog(null, "Enter Course Code");
        String title = JOptionPane.showInputDialog(null, "Enter Course Title");
        String credit = JOptionPane.showInputDialog(null, "Enter Course Credit");
        String prereqs = JOptionPane.showInputDialog(null, "Enter Prerequisites (Split by comma Ex. CIS*1000,CIS*1200)");
        String semester = JOptionPane.showInputDialog(null, "Enter Semester Offered");
        
        String[] prereqList = prereqs.split(",");
        model.addCoursetoCatalog(code, title, credit, prereqList, semester);
    }
    
        public void removeCoursefromCatalog()
    {
        String code = JOptionPane.showInputDialog(null, "Enter Course Code");
          
        model.removeCoursefromCatalog(code);
    }
    
       public void saveCatalog()
    {
        model.saveCatalog();
    }
}
