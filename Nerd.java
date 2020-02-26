//Minh Thao  Pd:6

public class Nerd extends Warrior
{
   public Nerd(String x)
   {
      super(x, "nerd");
   }
 
   public void generateStats()
   {
      IQ = (int)(Math.random()*61)+120;
      strength = (int)(Math.random()*61)+20;
   }
   
   public void victory()
   {
      System.out.println(name + " dispatches their opponent with a combo Jedi mind trick and Vulcan neck pinch!");
   }
}