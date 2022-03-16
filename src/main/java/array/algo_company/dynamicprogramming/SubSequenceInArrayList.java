package array.algo_company.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSequenceInArrayList {

    public static void main(String... args) {

        Integer[] array = new Integer[]{ 2, 3, 5,9};
        List<Integer> arr = Arrays.asList(array);

        int windowSize = 3;


        int size = arr.size();
        boolean[] usedArray = new boolean[size];
        ArrayList<List<Integer>> subsequence = new ArrayList<>();
        allSubset(arr, windowSize, 0, 0, usedArray, subsequence);

        int globalMax = 0;


        for(List<Integer> list : subsequence){

            int currentMin = Integer.MAX_VALUE;

            boolean[] userListArray = new boolean[list.size()];
            ArrayList<List<Integer>> pairsList = new ArrayList<>();
            allSubset(list, 2, 0, 0, userListArray, pairsList);

            for(List<Integer> pairs: pairsList){

                int result = Math.abs(pairs.get(1) - pairs.get(0));
                currentMin = Math.min(result,currentMin);
            }

            globalMax = Math.max(globalMax,currentMin);
        }

        System.out.print("\n"+globalMax);

        /*
          globalMaximum: 0

Subsequence: [2, 3, 5]
currentMinimum: 1000000000000000000
x: 3 y: 2 abs(x-y): 1 currentMinimum: 1
x: 5 y: 2 abs(x-y): 3 currentMinimum: 1
x: 5 y: 3 abs(x-y): 2 currentMinimum: 1
globalMaximum: max(globalMaximum, currentMinimum) = max(1, 0) = 1
         */


    }

    public static void allSubset(List<Integer> arr, int windowSize, int start, int currentLen, boolean[] used, List<List<Integer>> subsequenceList) {

        if (currentLen == windowSize) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                if (used[i] == true) {
                    list.add(arr.get(i));
                }
            }
            if (!list.isEmpty()) {
                subsequenceList.add(list);
            }
            return;
        }

        if (start == arr.size()) {
            return;
        }

        used[start] = true;
        allSubset(arr, windowSize, start + 1, currentLen + 1, used, subsequenceList);

        used[start] = false;
        allSubset(arr, windowSize, start + 1, currentLen, used, subsequenceList);
    }
}
