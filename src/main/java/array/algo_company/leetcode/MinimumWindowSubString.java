package array.algo_company.leetcode;

import java.util.HashMap;

public class MinimumWindowSubString {

    /**
     * Given two strings s and t, return the minimum window substring of s
     * such that every character in t (including duplicates) is included in the window.
     * If no such substring exists, return an empty string "".
     * s = "ADOBECODEBANC"
     * t = "ABC"
     * Output: "BANC"
     * <p>
     * Store the frequency of characters of t.
     * Use two pointers (left, right) to create a sliding window.
     * Expand right to include characters.
     * When all characters are matched:
     * Try shrinking from left to find the minimum window.
     * Track the smallest valid window.
     *
     * @param args
     */
    public static void main(String[] args) {
        String minWindowSubString = getMinWindowSubString("ADOBECODEBANC", "BANC");
        System.out.println("\nLongest Unique Substring: " + minWindowSubString);
        System.out.println("Unique SubString Length is :" + minWindowSubString.length());
    }

    static String getMinWindowSubString(String str, String subStr) {
        if (str == null || subStr == null || str.length() == 0 || subStr.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char ch : subStr.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }
        int requiredSize = targetMap.size();

        int left = 0;
        int right = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int formed = 0;
        int start = 0;

        HashMap<Character, Integer> windowMap = new HashMap<>();

        while (right < str.length()) {

            char currentChar = str.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            if (targetMap.containsKey(currentChar) &&
                    targetMap.get(currentChar).intValue() == windowMap.get(currentChar).intValue()) {
                formed++;
            }

            while (left <= right && formed == requiredSize) {

                int currentWidowLength = right - left + 1;
                if (currentWidowLength < minWindowLength) {
                    minWindowLength = currentWidowLength;
                    start = left;
                }

                //remove left char from window
                char leftChar = str.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    formed--;
                }

                left++;
            }
            right++;
        }
        return minWindowLength == Integer.MAX_VALUE ? "" : str.substring(start, start + minWindowLength);
    }

//    static String getMinWindowSubString(String str, String subStr) {
//        if (str == null || subStr == null) {
//            return "";
//        }
//        HashMap<Character, Integer> targetMap = new HashMap<>();
//        for (char character : subStr.toCharArray()) {
//            targetMap.put(character, targetMap.getOrDefault(character, 0) + 1);
//        }
//        int requiredSize = targetMap.size();
//
//        HashMap<Character, Integer> windowMap = new HashMap<>();
//        int right = 0;
//        int left = 0;
//        int formed = 0;
//        int minWindowLength = Integer.MAX_VALUE;
//        int start = 0;
//
//        while (right < str.length()) {
//
//            char currentChar = str.charAt(right);
//            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);
//
//            if (targetMap.containsKey(currentChar) &&
//                    targetMap.get(currentChar).intValue() == windowMap.get(currentChar).intValue()) {
//                formed++;
//            }
//
//            while (left <= right && requiredSize == formed) {
//
//                int currentWindowLength = right - left + 1;
//                if (currentWindowLength < minWindowLength) {
//                    minWindowLength = currentWindowLength;
//                    start = left;
//                }
//
//                char leftChar = str.charAt(left);
//                windowMap.put(leftChar, windowMap.get(leftChar).intValue() - 1);
//
//                if (targetMap.containsKey(leftChar) &&
//                        windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
//                    formed--;
//                }
//
//                left++;
//            }
//
//            right++;
//        }
//        return minWindowLength == Integer.MAX_VALUE ? "" : str.substring(start, start + minWindowLength);
//    }
}
