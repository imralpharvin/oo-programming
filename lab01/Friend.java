public class Friend
{
  
    String name;
    String contactInfo;
   
    public Friend()
    {
        this("none","none");
    }

    public Friend(String name, String contactInfo)
    {
        this.name = name;
        this.contactInfo = contactInfo;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setContactInfo(String contactInfo)
    {
        this.contactInfo = contactInfo;
    }
    
    public String getContactInfo()
    {
        return this.contactInfo;
    }
    
    
    
}
