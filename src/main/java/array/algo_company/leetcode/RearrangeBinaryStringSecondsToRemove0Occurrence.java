package array.algo_company.leetcode;

public class RearrangeBinaryStringSecondsToRemove0Occurrence {

    public static void main(String... args) {
        String s = "0110101";
        //Output: 4
        //Explanation:
        //After one second, s becomes "1011010".
        //After another second, s becomes "1101100".
        //After the third second, s becomes "1110100".
        //After the fourth second, s becomes "1111000".
        //No occurrence of "01" exists any longer, and the process needed 4 seconds to complete,
        //so we return 4.
        System.out.println(secondsToRemoveOccurrences(s));
    }

    private static int secondsToRemoveOccurrences(String s) {
        // 0110101
        int countZero = 0;
        int time = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                countZero++;
            } else {
                if (countZero > 0) {
                    time = Math.max(time + 1, countZero);
                }
            }
        }
        return time;
    }
}
