package array.algo_company.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumNumberOfEnvelopFolded {

    public static void main(String... args) {

        int[][] envelopes = new int[][]{
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        int envelopedNested = maxEnvelopes(envelopes);
        System.out.println("Folded Envelopes " + envelopedNested);

        System.out.println("Russian Dolls Envelopes " + findRussianDoll(envelopes));
    }

    public static int findRussianDoll(int[][] babyDolls) {

        // Step 1 sort with width,
        // if width same then height in DESC order to break increasing order pattern to remove invalid ones
        Arrays.sort(babyDolls, (a, b) -> {

            if (a[0] == b[0]) {
                return b[1] - a[1]; // height descending if width same
            }
            return a[0] - b[0];
        });

        // now width are in ASC and where width are same height will be in DESC
        // now it became a problem to find longest increasing subsequence for height
        List<Integer> lis = new ArrayList<>();
        for (int[] dolls : babyDolls) {
            int height = dolls[1];

            // if height not available in lis - will return -(size + 1);  // key not found
            int index = Collections.binarySearch(lis, height);

            if (index < 0) {
                index = -(index + 1);
            }

            if (index == lis.size()) {
                lis.add(height);
            } else {
                lis.set(index, height);
            }
        }
        return lis.size();
    }

    public static int maxEnvelopes(int[][] envelopes) {
        //Step-1 Sorting
        // You want the maximum number of envelopes you can nest such that:
        // w1 < w2 AND h1 < h2 -> sort with width , if width same then sort for height in DESC
        // Width → increasing
        // Height → decreasing (if widths equal)
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];  // height descending if width same
                // (We force invalid cases to break increasing order)
            }
            return a[0] - b[0]; // width ascending
        });

        // Now problem becomes: [only increasing order upto height are valid]
        // Find Longest Increasing Subsequence (LIS) in heights

        List<Integer> lis = new ArrayList<>();
        for (int[] env : envelopes) {
            int height = env[1];

            int idx = Collections.binarySearch(lis, height);

            if (idx < 0) {
                idx = -(idx + 1);
            }

            if (idx == lis.size()) {
                lis.add(height);
            } else {
                lis.set(idx, height);
            }
        }

        return lis.size();
    }
}
