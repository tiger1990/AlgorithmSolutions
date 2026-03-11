package array.algo_company.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given an array arr[] of n integers and a target value,
 * check if there exists a pair whose sum equals the target.
 * Input: arr[] = [0, -1, 2, -3, 1], target = -2
 * Output: true
 * Explanation: There is a pair (1, -3) with the sum equal to given target, 1 + (-3) = -2.
 * <p>
 * Input: arr[] = [1, -2, 1, 0, 5], target = 0
 * Output: false
 * Explanation: There is no pair with sum equals to given target.
 */
public class TwoSumPair {
    public static void main(String[] args) {

        int array[] = new int[]{0, -1, 2, -3, 1};
        findSumPair(array, -2);
    }

    /**
     * Hashing provides a more efficient solution to the 2-Sum problem.
     * Rather than checking every possible pair, we store each number in an
     * unordered set during iterating over the array's elements.
     * For each number, we calculate its complement (i.e., target - current number)
     * and check if this complement exists in the set. If it does,
     * we have successfully found the pair that sums to the target.
     * O(n) time and O(n) space
     *
     * @param array
     * @param target arr[] = [0, -1, 2, -3, 1], target = -2
     *               0, -1, 2, -3,
     */
    private static void findSumPair(int[] array, int target) {
        HashSet<Integer> set = new HashSet<>();

        HashMap<Integer, Integer> pairs = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int compliment = target - array[i];

            if (set.contains(compliment)) {
                pairs.put(array[i], compliment);
            } else {
                set.add(array[i]);
            }
        }

        for (Map.Entry<Integer, Integer> entry : pairs.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
}
