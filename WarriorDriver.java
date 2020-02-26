//Minh Thao

import java.io.*;
import java.util.*;

public class WarriorDriver
{

   public static int getFileSize(String fileName) throws IOException
   {
      Scanner input = new Scanner(new FileReader(fileName));
      int size = 0;
      while(input.hasNextLine())
      {
         size++;
         input.nextLine();
      }
      input.close();
      return size;
   }

   public static void readFile(String[] words, String fName)throws IOException
   {
      Scanner input = new Scanner(new FileReader(fName));
      int i = 0;
      String line;
      while(input.hasNextLine())
      {
         line = input.nextLine();
         words[i]=line;
         i++;
      }
      input.close();
   }
   
   public static void readFile2(Warrior[]words, String fName)throws IOException
   {
      Scanner input = new Scanner(new FileReader(fName));
      int i = 0;
      String name, clique;
      while(input.hasNextLine())
      {
         name = input.nextLine();
         clique = input.nextLine();
         if(clique.equals("nerd"))
         {
            words[i] = new Nerd(name);
         }
         else
         {
            if(clique.equals("prep"))
            {
               words[i] = new Prep(name);
            }
            else
            {
               if(clique.equals("freak"))
               {
                  words[i] = new Freak(name);
               }
               else
               {
                  if(clique.equals("jock"))
                  {
                     words[i] = new Jock(name);
                  }
                  else
                  {
                     if(clique.equals("thug"))
                     {
                        words[i] = new Thug(name);
                     }
                  }
               }
            }
         }
         i++;
      }
      input.close();
   }

   public static void fight(Warrior x, Warrior y)
   {
      if(x.getIQ() > y.getIQ()+20)
      {
         x.victory();
         System.out.println(x.getName() + " outsmarts " + y.getName());
      }
      else
      {
         if(y.getIQ() > x.getIQ()+20)
         {
            y.victory();
            System.out.println(y.getName() + " outsmarts " + x.getName());
         }
         else
         {
            if(x.getStrength()>y.getStrength())
            {
               x.victory();
               System.out.println("Warrior " + x.getName() + " wins on strength");
            }
            else
            {
               if(y.getStrength()>x.getStrength())
               {
                  y.victory();
                  System.out.println("Warrior " + y.getName() + " wins on strength");
               }
            }
         }
      }
   }

   public static int random(int size)
   {
      return (int)(Math.random()*size);
   }

   public static void main(String[]arg)throws IOException
   {
      int size = getFileSize("NerdWars.txt");
      Warrior[] arena = new Warrior[size/2];
      readFile2(arena, "NerdWars.txt");
      
      int x = random(size/2);
      int y = random(size/2);
      
      if(arena[x].errorCheck() && arena[y].errorCheck())
      {
         System.out.println(arena[x]);
         System.out.println(arena[y]);
         
         fight(arena[x], arena[y]);
      }
      
      else
      {
         System.out.println("Invalid Social Clique");
      }
   }
}
