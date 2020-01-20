import java.util.HashMap;

public class CoffeeShop
{
   private double drinkCost;
   private String drinkSize;
   private String drink;
   private String extras;
   private Integer sizeNum;
   private HashMap <String, Double> prices;
   
    public CoffeeShop()
    {
        drinkCost = 0;
        drinkSize = null;
        drink = null;
        extras = null;
        prices = new HashMap <String, Double> ();


    }

    public CoffeeShop(String drink, String drinkSize,  String extras)
    {
        this.drink = drink;
        this.drinkSize = drinkSize;
        this.extras = extras;
        this.prices = new HashMap <String, Double> ();
        prices.put("Latte", 3.0);
        prices.put("Cappucino", 4.0);
        prices.put("Whipped Cream", 0.5);
        prices.put("No Extras", 0.0);
    }
    
    //Enumeration
    public enum SIZES
    {
        S,M,L,XL
    }
    
    public void setDrinkSize(String drinkSize)
    {
        this.drinkSize = drinkSize;
    }
    
    public String getdrinkSize()
    {
        return drinkSize;   
    }
    
    public void setPrices(HashMap <String, Double> prices)
    {
        this.prices = prices;
    }
    
    public HashMap <String, Double> getPrices()
    {
        return prices;
    }
   
    public void setDrink(String drink)
    {
        this.drink = drink;
    }
    
    public String getDrink()
    {
        return drink;   
    }
    
     public void setExtras(String extras)
    {
        this.extras = extras;
    }
    
    public String getExtras()
    {
        return extras;   
    }
    
    public void setDrinkCost(double drinkCost)
    {
        this.drinkCost = drinkCost;
    }
    
    public double drinkCost()
    {
        double S = 1;
        double M = 1.5;
        double L = 1.75;
        double XL = 2.0;
        double multiplier = 1;;
        
        if(drinkSize.equals("S"))
        {
            multiplier = S;
        }
        
        else if(drinkSize.equals("M"))
        {
            multiplier = M;
        }
        
        else if(drinkSize.equals("L"))
        {
            multiplier = L;
        }
        
        else if(drinkSize.equals("XL"))
        {
            multiplier = XL;
        }
        return (prices.get(drink) + prices.get(extras)) * multiplier ;   
    }
    
    //toString
    public String toString()
    {

        return "The total cost of your order is $" + drinkCost() + "\n";
    }
    
    //Overload Method
    public boolean equals(String size)
    {
        if(size == "S" || size == "M" || size == "L" || size == "XL")
        {
            return true;
        }
        return false;
    }
}
