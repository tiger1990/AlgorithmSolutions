package array.algo_company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CumulativeOccurrences {

    public static void main(String[] args) {

        int nums[] = {4,2,4,3,5,6,2};
        // 0-2 , 1-6 | 2-0 | 0, 0, 0, 6-1
        // [2, 5, 2, 0, 0, 5]

        int[] result = findCumulativeOccurrences(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findCumulativeOccurrences(int[] nums) {
        int[] result = new int[nums.length];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for(int j=0;j<nums.length;j++){
            if (map.containsKey(nums[j])) {
                List<Integer> list = map.get(nums[j]);
                int absSum = 0;
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(k) != j) {
                       absSum += Math.abs(j - list.get(k));
                    }
                }
                result[j] = absSum;
            }
        }

        return result;
    }
}


