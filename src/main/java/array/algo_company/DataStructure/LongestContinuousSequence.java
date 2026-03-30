package array.algo_company.DataStructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestContinuousSequence {

    public static void main(String[] args) {
        int[] numbers = {5, 100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length: "
                + longestConsecutive(numbers));
    }

    private static int longestConsecutive(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        HashSet<Integer> numberSet = new HashSet<>();
        for (int num : numbers) {
            numberSet.add(num);
        }

        int longest = 0;
        for (int num : numberSet) {

            // start counting if num-1 is not in set
            if (!numberSet.contains(num - 1)) {

                int currentNum = num;
                int length = 1;

                while (numberSet.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
