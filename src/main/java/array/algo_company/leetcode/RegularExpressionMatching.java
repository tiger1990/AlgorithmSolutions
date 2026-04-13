package array.algo_company.leetcode;

/**
 * Given an input string s and a pattern p,
 * implement regular expression matching with support for '.' and '*' where:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * Return a boolean indicating whether the matching covers the entire input string (not partial).
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));   // false
        System.out.println(isMatch("aa", "a*"));  // true
        System.out.println(isMatch("ab", ".*"));  // true
    }

    /**
     * DP visualization
     * i,j   ""   a   *
     * ""    T    F   T
     * a     F    T   T
     * aa    F    F   T
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // base case for empty string
        dp[0][0] = true;

        //handle pattern a, a*, a*b* pattern for empty string
        //dp[0][j] → does EMPTY string "" match pattern p[0..j-1] ?
        // j=2  Because * always depends on the previous character, '*' cannot exist alone
        //It always refers to the character BEFORE it
        // j = 0 → ""
        // j = 1 → "a"
        // j = 2 → "a*"
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Case 1: direct match or '.'
                if (p.charAt(j - 1) == s.charAt(i - 1) ||
                        p.charAt(j - 1) == '.'
                ) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Case 2: '*'
                if (p.charAt(j - 1) == '*') {

                    // zero occurrence
                    dp[i][j] = dp[i][j - 2];

                    // One or more occurrence
                    if (p.charAt(j - 2) == s.charAt(i - 1)
                            || p.charAt(j - 2) == '.') {

                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}


