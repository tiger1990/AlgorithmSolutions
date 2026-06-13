package array.algo_company.leetcode;

public class RecursionNumberPrint {

    private static final int STEP = 5;

    public static void main(String[] args) {
        // output     : 10 5 0 5 10
        // num = 11   : 11 6 1 -4 1 6 11
        printDownAndUp(10);
        System.out.println("\n---");
        printDownAndUp(11);

        System.out.println("\n---");
       findCumulativeOccurrences(11, 5);
    }

    public static void findCumulativeOccurrences(int num, int step) {
        System.out.print(num+ " ");
        if (num <= 0) return;
        findCumulativeOccurrences(num - step, step);
        System.out.print(num+ " ");
    }

    /**
     * Prints the number, recurses downward by STEP until the value drops to 0
     * or below (the turning point, printed once), then prints the number again
     * on the way back up — producing a symmetric down-then-up sequence.
     */
    public static void printDownAndUp(int num) {
        System.out.print(num + " ");
        if (num <= 0) {
            return; // turning point: printed once, no further descent
        }
        printDownAndUp(num - STEP);
        System.out.print(num + " ");
    }
}
