//Minh Thao

public class Freak extends Warrior
{
   public Freak(String x)
   {
      super(x, "freak");
   }
 
   public void generateStats()
   {
      IQ = (int)(Math.random()*121)+60;
      strength = (int)(Math.random()*100)+1; 
   }
   
   public void victory()
   {
      System.out.println(name + " won their opponent with a bazoka");
   }
}