package array.algo_company.DataStructure;

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
        Set<Integer> numbersSet = new HashSet<>();
        for (int num : numbers) {
            numbersSet.add(num);
        }

        int longest = 0;
        for (int num : numbersSet) {

            // start counting if num-1 is not in set
            if (!numbersSet.contains(num - 1)) {

                int current = num;
                int length = 1;

                while (numbersSet.contains(current + 1)) {
                    length++;
                    current++;
                }

                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
