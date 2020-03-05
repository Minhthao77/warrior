//Minh Thao

import java.io.*;
import java.util.*;

public class WarriorDriver
{
   public static Scanner input = new Scanner(System.in);

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
   
   public static String show(String fileName) throws IOException
   {  
      int size2 = getFileSize(fileName);
      String[] list = new String[size2];
      readFile2(list, fileName);
      int r = random(size2);
    	
      return list[r];
   }
   
   public static String createInsult(String n)throws IOException
   {
      return n + " " + show("verbPhrases.TXT") + " " + show("adjectives.TXT") + " " + show("nouns.TXT") ;
   }
         
   public static void readFile2(String[] words, String fileName)throws IOException
   {
      Scanner input = new Scanner(new FileReader(fileName));
      int i=0;
      String line;
      while(input.hasNextLine())
      {
         line = input.nextLine();
         words[i]= line;
         i++;
      }
      input.close();
   }
   
   public static void readFile(Warrior[]words, String fName)throws IOException
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

   private static void swap(Warrior[] arena, int a, int b)
   {
      Warrior temp = arena[a];
      arena[a] = arena[b];
      arena[b] = temp;
   }

   public static void selSort(Warrior[] arena, int d)
   {
      int k = d;
      int min, size = arena.length;
      for(int x = 0; x<size; x++)
      {
         min = x;
         for(int y =x+1; y<size;y++)
         {
            if(k == 1)
            {
               if(arena[y].getIQ()< arena[min].getIQ())
                  min = y;
            }
            else
            {
               if(k==2)
               {
                  if(arena[y].getStrength()< arena[min].getStrength())
                     min = y;
               }
               else
               {
                  if(k == 3)
                  {
                     if(arena[y].getName().compareTo(arena[min].getName())<0)
                        min = y;
                  }
               }
            }
         }
         swap(arena,x,min);
      }
   }

   public static void display(Warrior[]arena)
   {
      for(int t = 0; t<arena.length; t++)
      {
         System.out.println(arena[t]);
      }
      System.out.println();
   }

   public static void main(String[]arg)throws IOException
   {
   
      int size = getFileSize("NerdWars.txt");
      Warrior[] arena = new Warrior[size/2];
      readFile(arena, "NerdWars.txt");
      
      int x = random(size/2);
      int y = random(size/2);
      display(arena);
      
      System.out.println("1) Sort by IQ  2) Sort by Strength  3) Sort by Name  4) Skip");
      int opt = input.nextInt();
      
      while(opt < 0 || opt >4)
      {
         System.out.println("1) Sort by IQ  2) Sort by Strength  3) Sort by Name  4) Skip");
         opt = input.nextInt();
      }
      
      selSort(arena, opt);
      if(opt>0 && opt<4)
         display(arena);
      
      if(arena[x].errorCheck() && arena[y].errorCheck())
      {
         System.out.println(arena[x].getName() + " says:");
         System.out.println(createInsult(arena[y].getName()));
      
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
