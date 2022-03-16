package array;

import array.algo_company.DataStructure.dynamicarray.DynamicArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Anagram
{
    private static int[] Track;

    public static void main(String... args)
    {
        DynamicArray<String> dynamicArray = new DynamicArray<>(4);
        dynamicArray.add("Listen");
        dynamicArray.add("Silent");
        dynamicArray.add("Enlist");
        dynamicArray.add("Ama");
        dynamicArray.add("Sas");
        dynamicArray.add("Ass");
        dynamicArray.add("Check");

        Track = new int[dynamicArray.size()];

        TreeMap<String,String> anagramMap = new TreeMap<>();
        fillAnagram(anagramMap,dynamicArray);
        Iterator<Map.Entry<String,String>> anagIterator = anagramMap.entrySet().iterator();
        while(anagIterator.hasNext())
        {
           Map.Entry<String,String> entry =  anagIterator.next();
           System.out.println(entry.getValue());
        }
    }

    private static void fillAnagram(TreeMap<String, String> anagramMap, DynamicArray<String> dynamicArray)
    {
        int size = dynamicArray.size();
        for(int i = 0; i < size; i++)
        {
            String data = dynamicArray.get(i);

            int traversed = i+1;
            if(Track[i] == 1)continue;

            anagramMap.put(data,data);

            while(traversed != size)
            {
                String dataNext = dynamicArray.get(traversed);
                boolean isBothAnagram = isAnagram(data,dataNext);
                if(isBothAnagram)
                {
                    anagramMap.put(data,anagramMap.get(data)+","+dataNext);
                    Track[traversed] = 1;
                }
                traversed++;
            }
        }
    }


    private static boolean isAnagram(String data, String dataNext)
    {
       char[] dataOld = data.toLowerCase().toCharArray();
       Arrays.sort(dataOld);

       char[] dataNew = dataNext.toLowerCase().toCharArray();
       Arrays.sort(dataNew);

       if(Arrays.equals(dataOld,dataNew))
       {
           return true;
       }
       return false;
    }
}
