/*Do problem 6.4 (recursively) on page 313. The input should be captured on a single line in a window,
such as for the example, but with the target  FIRST followed by the weights, on page 306 (there
will be no repeated values). Permit the user to enter all the numbers on one line:

**********THERE WILL BE NO DEDUCT IF YOU DECIDE TO USE THE CONSOLE FOR INPUT.
20 11 8 7 6 5
In this case the output would be:
8 7 5*/


import java.util.Scanner;
import java.io.*;
import java.util.Scanner;
import java.lang.NumberFormatException;
import java.util.Arrays;

public class Sack
{
   public static void sackFiller(int target, int[] knapSack, int[] weights, int currentIndex, int i)
   {
      int[] newKnapSack = knapSack.clone();
      if(target == 0)
      {
         for( int j = 0;j < newKnapSack.length;j++)
         {
            if(newKnapSack[j] != 0)
            {
               if(j == 0 )
               {
                 System.out.print(newKnapSack[j]); 
               }
               
               else
               {
                  System.out.print(", " + newKnapSack[j]);
               }
            }     
         }         
         System.out.println();
      }
      
      else if(currentIndex < weights.length && target > 0)
      {
         sackFiller(target, newKnapSack, weights, currentIndex + 1, i);
         newKnapSack[i] = weights[currentIndex];
         sackFiller(target - weights[currentIndex], newKnapSack, weights, currentIndex + 1, i + 1);
      }          
   }
    
//Main
   public static void main(String[] args)
   {
      System.out.println("Enter a capasity followed by weights on one line");
      Scanner input = new Scanner(System.in);
      int[] weights = new int[25];
      int[] knapSack = new int[25];

      String data = input.nextLine();

      String tmpDataArray[] = data.split(" ");

      int dataArray[] = new int[tmpDataArray.length];
      for (int i = 0; i < dataArray.length; ++i) {
          dataArray[i] = Integer.parseInt(tmpDataArray[i]);
      }
      
      int target = dataArray[0];
      for (int i = 1; i < dataArray.length; ++i) {
          weights[i - 1] = dataArray[i];
      }
      input.close();
      sackFiller(target, knapSack, weights, 0, 0);
   }
} 
  