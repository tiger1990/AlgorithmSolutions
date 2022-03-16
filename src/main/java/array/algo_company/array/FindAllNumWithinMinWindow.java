package array.algo_company.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumWithinMinWindow {
    public static void main(String... args){
        int arr[] = new int[]{7,3,  7,3,1,1,4,  7,3,1,4};// ans = min(5,4)

        HashSet uniqueNumSet = new HashSet();
        for(int i=0;i <arr.length;i++){
            uniqueNumSet.add(i);
        }
        int minWindowSize= uniqueNumSet.size();

        List<Integer> allNumbs = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = minWindowSize;

        for(int j=leftIndex;j < rightIndex;j++){
            allNumbs.add(arr[j]);
        }

        for(int k=rightIndex;k <arr.length;k++){

        }
    }
}
