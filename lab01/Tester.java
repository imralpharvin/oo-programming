
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
   public static void main(String[] args)
   {
       //Constructor 1
       Friend friend1 = new Friend();
       //Constructor 2
       Friend friend2 = new Friend("ralph", "647");
       //Set and get name
       System.out.println("Set name ralph to ralph2");
       friend2.setName("ralph2");
       System.out.println("Name: " + friend2.getName());
        //Set and get contactInfo
       System.out.println("Set contactinfo 647 to 648");
       friend2.setContactInfo("648");
       System.out.println("Contact Info: " + friend2.getContactInfo());
       
       Contacts contactList = new Contacts();
       
       //addFriend
       System.out.println("Adding amy with number");
       contactList.addFriend("amy","64756");
       contactList.addFriend("bob","64757");
       contactList.addFriend("cass","64758");
       //num
       System.out.println("Number of Friends: " + contactList.numFriends());
       //getContactInfo
       System.out.println("Contact Info: " + contactList.getContactInfo("amy"));
       //removeFriend - gives an error
       //contactList.removeFriend("amy","64756");
   }
}
