package array.algo_company.leetcode;

import java.util.HashMap;

public class LongestSubString {

    public static void main(String... args){

        System.out.println(lengthOfLongestSubstring("abcabcbb"));

        System.out.println("8397110102111117110100114121".length());
    }

    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {

           char ch = s.charAt(end);
            // If we have seen the number, move the start pointer to position after the last occurrence
           if(map.containsKey(ch)){
               start = Math.max(start, map.get(ch)+1);
           }
           map.put(ch, end);
           maxLength = Math.max(maxLength, end - start +1);
        }

        return maxLength;
    }
}
