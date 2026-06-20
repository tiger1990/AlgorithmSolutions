package array.algo_company.leetcode;

public class PalindromeNumberCheck {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1000000001));
    }

    public static boolean isPalindrome(int x) {
        int initialNum = x;
        int finalNum = 0;
        if (x < 0) return false;

        while (initialNum > 0) {
            int remain = initialNum % 10;
            initialNum = initialNum / 10;

            int step = initialNum > 0 ? 10 : 1;
            int add = finalNum + remain;
            finalNum = add * step;
        }
        return x == finalNum;
    }
}
