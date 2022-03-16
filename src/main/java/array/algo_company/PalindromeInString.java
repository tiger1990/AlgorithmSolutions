package array.algo_company;

import java.util.ArrayList;

public class PalindromeInString
{

   public static void main(String... args)
   {
       ArrayList<String> palindromeList = printAllPalindromes("BABAMM");
       for(String palindromes : palindromeList)
       {
           System.out.println(palindromes);
       }
   }

    public static  ArrayList<String> printAllPalindromes(String input) {
        ArrayList<String> palindromeList = new ArrayList<>();

        for(float pivot=0;pivot<input.length();pivot+= 0.5)
        {
            float palindromeRadius = pivot - (int)pivot;

            while((pivot - palindromeRadius) >= 0 && (pivot + palindromeRadius) < input.length()
                    && input.charAt((int)(pivot - palindromeRadius)) == input.charAt((int)(pivot + palindromeRadius)))
            {

                palindromeList.add(input.substring((int)(pivot - palindromeRadius), (int)((pivot + palindromeRadius) + 1)));
                palindromeRadius++;
            }

        }
        return  palindromeList;
    }
}
