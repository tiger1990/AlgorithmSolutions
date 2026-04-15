package array.algo_company.leetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String input = "abacdaabbaabb";
        System.out.println(longestPalindrome(input));

        System.out.println(longestPalindromeManx(input));

        System.out.println(optimizeByManchers(input));
    }

    public static String longestPalindromeManx(String s) {
        if (s == null || s.isEmpty()) return "";

        // Transform string
        StringBuilder t = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            t.append("#").append(c);
        }
        t.append("#$");

        char[] arr = t.toString().toCharArray();
        int n = arr.length;

        int[] P = new int[n];
        int center = 0, right = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                P[i] = Math.min(right - i, P[mirror]);
            }

            // Expand around center i
            while (arr[i + (1 + P[i])] == arr[i - (1 + P[i])]) {
                P[i]++;
            }

            // Update center and right boundary
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }

        // Find max palindrome
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        // Extract result from original string
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    // Time: O(n)^2 || Space: O(1)
    public static String longestPalindrome(String input) {

        if (input == null || input.isBlank()) {
            return "";
        }
        int length = input.length();

        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < length; i++) {

            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;

                while (left >= 0 && right < length && input.charAt(left) == input.charAt(right)) {

                    int currentLength = right - left + 1;

                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        start = left;
                    }

                    left--;
                    right++;
                }

            }
        }
        System.out.println("Start Index:" + start + " End Index:" + (start + maxLength));
        return input.substring(start, start + maxLength);
    }

    private static String optimizeByManchers(String input) {
        Mancher mancher = new Mancher(input);

        int length = input.length();
        int maxLength = 1;
        int start = 0;

        for (int i = 0; i < length; i++) {
            // for odd length
            int oddLength = mancher.getLongest(i, 1);
            if (oddLength > maxLength) {
                // update start of odd length palindrome
                start = i - (oddLength - 1) / 2;
            }

            // for even length
            int evenLength = mancher.getLongest(i, 0);
            if (evenLength > maxLength) {
                // update start of even length palindrome
                start = i - (evenLength - 1) / 2;
            }

            maxLength = Math.max(maxLength, Math.max(evenLength, oddLength));
        }

        return input.substring(start, start + maxLength);
    }

    // Manacher’s Approach O(n) time and O(n) space
    static class Mancher {

        String ms;

        // radius of palindrome centered at position i in ms
        int[] p;

        public Mancher(String input) {
            StringBuilder sb = new StringBuilder("@");
            for (char ch : input.toCharArray()) {
                sb.append("#").append(ch);
            }
            //right sentinal
            ms = sb.append("#$").toString();
            executeMancher();
        }

        // return radius of longest palindrome form mid given
        public int getLongest(int mid, int evnOdd) {
            int pos = 2 * mid + 2 + (evnOdd == 0 ? 1 : 0);
            return p[pos];
        }

        // check if its substring left ---right is palindrome
//        public boolean isSubStringPalindrome(int left, int right) {
//            int res = getLongest((right + left) / 2, (right - left + 1) % 2);
//            return (right - left + 1) <= res;
//        }

        private void executeMancher() {
            int length = ms.length();
            int left = 0;
            int right = 0;
            p = new int[length];

            for (int i = 1; i < length - 1; i++) {

                int mirror = left + right - i;
                if (mirror > 0 && mirror < length) {
                    p[i] = Math.clamp(right - i, 0, p[mirror]);
                    //p[i] = Math.max(0, Math.min(right - i, p[mirror]));

                } else {
                    p[i] = 0;
                }

                //expanding around center
                // i + 1 + p[i] --- i - 1 - p[i]
                while ((i + 1 + p[i]) < length && (i - 1 - p[i]) > 0 &&
                        ms.charAt(i + 1 + p[i]) == ms.charAt(i - 1 - p[i])) {
                    p[i]++;
                }

                // update left and right in new palindrome beyond current right boundary
                if (i + p[i] > right) {
                    left = i - p[i];
                    right = i + p[i];
                }
            }
        }
    }

}
