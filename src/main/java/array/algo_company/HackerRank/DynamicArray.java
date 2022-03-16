package array.algo_company.HackerRank;

import java.io.*;
import java.util.*;

public class DynamicArray {

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

        List<List<Integer>> seq = new ArrayList<>(n);
        for(int i=0; i < n; i++) {
            seq.add(new ArrayList());
        }

        int last =0;
        int len = queries.size();

        List<Integer> ans = new ArrayList();

        for(int i=0; i<len; i++)
        {
            int x= queries.get(i).get(1);
            int y = queries.get(i).get(2);

            int idx = (x ^ last)%n;
            if(queries.get(i).get(0)==1)
            {
                seq.get(idx).add(y);
            }
            else if(queries.get(i).get(0)==2)
            {
                int ind = y % (seq.get(idx).size());
                last = seq.get(idx).get(ind);
                ans.add(last);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        List<List<Integer>> queriesInput = new ArrayList<>();
        queriesInput.add(Arrays.asList(1,0,5));
        queriesInput.add(Arrays.asList(1,1,7));
        queriesInput.add(Arrays.asList(1,0,3));
        queriesInput.add(Arrays.asList(2,1,0));
        queriesInput.add(Arrays.asList(2,1,1));

        List<Integer> ans = dynamicArray(2,queriesInput);

        for(Integer it:ans){
            System.out.print("\n"+it);
        }


        List<String> strings = new ArrayList<>();
        strings.add("ab");
        strings.add("ab");
        strings.add("abc");
        List<String> queries = new ArrayList<>();
        queries.add("ab");
        queries.add("abc");
        queries.add("bc");

        matchingStrings(strings,queries);
    }


    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        HashMap<String,Integer> map = new HashMap();
        for(String string:strings){
            map.put(string, map.getOrDefault(string,0)+1);
        }
        List<Integer> integer = new ArrayList<>();
        for(String query: queries){
            integer.add(map.getOrDefault(query,0));
        }
        return integer;
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        int arr[] = new int[n];

        for(List<Integer> list:queries){

            int a = list.get(0);
            int b = list.get(1);
            int num = list.get(2);

            int round = a;
            while(round <= b){
                arr[round] = arr[round]+num;
            }
        }

        long max = arr[0];
        for(int i=0; i< arr.length;i++){

            if( arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}