//Minh Thao

public class Jock extends Warrior
{
   public Jock(String x)
   {
      super(x, "jock");
   }
 
   public void generateStats()
   {
      IQ = (int)(Math.random()*61)+80;
      strength = (int)(Math.random()*51)+50;
   }
   
   public void victory()
   {
      System.out.println(name + " won the fight by their laser eyes");
   }
}