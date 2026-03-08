package array.algo_company.leetcode;

import java.util.HashMap;

class LongestSubstringUniqueChar {

    public static void main(String[] args) {
        String str = "abcabcbb";

        String longestUniqueSubString = longestSubString(str);
        System.out.println("Longest Unique Substring: " + longestUniqueSubString);
        System.out.println("Unique SubString Length is :" + longestUniqueSubString.length());

        String optimizedLongestSubString = optimizedLongestSubString(str);
        System.out.println("\nLongest Unique Substring: " + optimizedLongestSubString);
        System.out.println("Unique SubString Length is :" + optimizedLongestSubString.length());
    }

    /**
     * This method finds the longest substring without repeating characters
     * using the Sliding Window technique.
     */
    static String longestSubString(String str) {

        // Edge case: if string is empty or has only one character
        if (str == null || str.length() <= 1) {
            return str;
        }

        String subString = "";   // Stores the longest unique substring
        int result = 0;          // Stores the length of the longest substring

        // Boolean array to mark visited characters (assuming lowercase letters)
        boolean[] visited = new boolean[26];

        // left and right pointer of sliding window
        int left = 0, right = 0;

        // Traverse the string using the right pointer
        while (right < str.length()) {

            //If current character is repeated, move left pointer forward and mark characters
            //as unvisited until the duplicate is removed.
            while (visited[str.charAt(right) - 'a']) {
                visited[str.charAt(left) - 'a'] = false;
                left++;
            }

            //Mark current character as visited
            visited[str.charAt(right) - 'a'] = true;

            // The length of the current window (right - left + 1)
            // is calculated and answer is updated accordingly.
            // Calculate current window length
            int currentLength = right - left + 1;
            if (currentLength > result) {
                subString = str.substring(left, right + 1);
                result = currentLength;
            }
            right++;
        }

        return subString;
    }

    /**
     * Works for all characters
     * More optimized HashMap so it works for all characters (ASCII / Unicode).
     * Time Complexity	O(n)
     * Space Complexity	O(min(n, charset))
     *
     * @param str
     * @return
     */
    static String optimizedLongestSubString(String str) {

        if (str == null || str.length() <= 1) {
            return str;
        }
        int maxLength = 0;
        int left = 0;
        int right = 0;

        // Starting index of longest substring
        int startIndex = 0;

        // Map stores character and its latest index
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < str.length()) {

            char currentChar = str.charAt(right);
            /*
             If character already exists in the map and
             its index is inside the current window,
             move the left pointer to one position
             after the previous occurrence.
            */
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                // left = map.get(currentChar) + 1;
                left = Math.max(left, map.get(currentChar) + 1); //This avoids moving the pointer backwards.
            }

            // Update latest index of the character
            map.put(currentChar, right);

            // Calculate current window length
            int currentWindowLength = right - left + 1;

            // Update max substring info
            if (currentWindowLength > maxLength) {
                maxLength = currentWindowLength;
                startIndex = left;
            }

            right++;
        }
        return str.substring(startIndex, startIndex + maxLength);
    }
}