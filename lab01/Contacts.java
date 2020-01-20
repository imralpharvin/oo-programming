
import java.util.ArrayList;

public class Contacts
{
    ArrayList<Friend> contactList; 
    
    public Contacts()
    {
        contactList = new ArrayList<Friend>();
    }
    
    public void addFriend(String name, String contactInfo)
    {
        if(name == null || contactInfo == null)
        {
           System.out.println("Null");
           return;
        }
        
        Friend friend1 = new Friend(name, contactInfo);
        contactList.add(friend1);
    }
    
    public void removeFriend(String name, String contactInfo)
    {
        if(name == null || contactInfo == null)
        {
           System.out.println("Null");
           return;
        }
        for(Friend friend: contactList)
        {
            if(name.equals(friend.name) && contactInfo.equals(friend.contactInfo))
            {
                contactList.remove(friend);
            }
        }
    }
    
    public String getContactInfo(String name)
    {
        if(name == null)
        {
           System.out.println("Null");
           return null;
        }
        
        for(Friend friend: contactList)
        {
            if(name.equals(friend.name))
            {
                return friend.getContactInfo();
            }
            
        }
        return null;
    }
    
    public int numFriends() //returns the number of items in the collection
    {
        return contactList.size();
    }
}
