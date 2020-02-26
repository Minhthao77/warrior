// Minh Thao

public class Prep extends Warrior
{
   public Prep(String x)
   {
      super(x, "prep");
   }
 
   public void generateStats()
   {
      IQ = (int)(Math.random()*61)+90;
      strength = (int)(Math.random()*31)+40;
   }
   
   public void victory()
   {
      System.out.println(name + " won the fight by their super punch");
   }
}