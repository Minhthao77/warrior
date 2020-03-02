//Minh Thao


public abstract class Warrior
{
   protected String name;
   protected int IQ;
   protected int strength;
   protected String clique;
   
   public Warrior(String n, String sc)
   {
      name = n;
      clique = sc;
      generateStats();
      clique.toLowerCase();
   }
   
   public abstract void generateStats();
   
   public abstract void victory();
   
   public boolean errorCheck()
   {
      if(clique.equals("freak") || clique.equals("thug") || clique.equals("prep") || clique.equals("jock") || clique.equals("nerd"))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public String getName()
   {
      return name;
   }
   
   public int getStrength()
   {
      return strength;
   }
   
   public int getIQ()
   {
      return IQ;
   }

   public String toString()
   {
      return "Name:" + name + "  Clique:" + clique + "  IQ:" + IQ + "  Strength:" + strength;
   }

}