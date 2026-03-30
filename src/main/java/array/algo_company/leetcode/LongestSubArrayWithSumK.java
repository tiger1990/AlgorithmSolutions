package array.algo_company.leetcode;

import java.util.HashMap;

public class LongestSubArrayWithSumK {
    public static void main(String... args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLenLongestZeroSumSubarray(arr)); // Output: 5

        int[] arr1 = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(maxLenLongestKSumSubarray(arr1, k)); // Output: 5
    }

    /**
     * {15, -2, 2, -8, 1, 7, 10, 23};
     * 15,0
     * 13,1
     * 15,2 X no because -> 15 already exists at index 0
     * 👉 Subarray from (0+1 to 2) → [ -2, 2 ]
     * <p>
     * Longest subarray length = 5
     * Subarray = [-2, 2, -8, 1, 7]
     * <p>
     * Whenever prefix sum repeats, it means the elements in between sum to zero.
     * We store the first occurrence to maximize subarray length.
     */
    private static int maxLenLongestZeroSumSubarray(int[] arr) {
        int sum = 0;
        int maxLength = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: sum becomes 0
            if (sum == 0) {
                maxLength = i + 1;
            }

            // Case 2: sum seen before
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
                //Subarray from (0+1 to index)
            } else {
                // store first occurrence only
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    /**
     * {10, 5, 2, 7, 1, 9}; k = 15
     * Longest subarray length = 4
     * Subarray = [5, 2, 7, 1]
     */
    private static int maxLenLongestKSumSubarray(int[] arr, int k) {
        int sum = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLength = i + 1;
            }
            // Case 2: (sum - k) seen before
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - -map.get(sum - k));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
