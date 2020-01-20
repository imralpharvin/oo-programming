
public class CoffeeDemo
{

    
   public CoffeeDemo()
   {
        
   }


  public static void main(String[] args)
  {
      String drink;
      String size;
      String extras;
      
      CoffeeShop cShop1 = new CoffeeShop();
      cShop1.getPrices().put("Latte", 3.0);
      cShop1.getPrices().put("Cappucino", 4.0);
      cShop1.getPrices().put("Whipped Cream", 0.5);
      cShop1.getPrices().put("No Extras", 0.0);
      System.out.println("Welcome to Coffee Shop!");
      System.out.println("What drink do you want to get?\nUser: Latte");
      drink = "Latte";
      cShop1.setDrink(drink);
      System.out.println("What size do you want to get?\nUser: XL");
      size = "XL";
      cShop1.setDrinkSize(size);
      System.out.println("Any extras?\nUser: Whipped Cream");
      extras = "Whipped Cream";
      cShop1.setExtras(extras);
      System.out.println(cShop1.toString());

      System.out.println("What drink do you want to get?\nUser: Cappucino");
      System.out.println("What size do you want to get?\nUser: M");
      System.out.println("Any extras?\nUser: No Extras");
      CoffeeShop cShop2 = new CoffeeShop("Cappucino", "M", "No Extras");
      System.out.println(cShop2.toString());
    }
}
