//Minh Thao

public class Thug extends Warrior
{
   public Thug(String x)
   {
      super(x, "thug");
   }
 
   public void generateStats()
   {
      IQ = (int)(Math.random()*31)+60;
      strength = (int)(Math.random()*21)+80;
   }
   
   public void victory()
   {
      System.out.println(name + " won the fight by their bare hand");
   }
}