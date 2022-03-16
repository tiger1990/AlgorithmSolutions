package array.algo_company.array;

public class Test {

    public static void main(String... args) {
        int arr[] = {-1, 2, 3, -4, 5, -6, -7};
        //System.out.println("MAX SUM:  "+findSubArrayWithMaxSum(arr));

        System.out.println(""+isPalindrome(123));

        int module = 18 % 10;

        int divide = 18 / 10;

        System.out.println("   modulo:"+module+"   divide:"+divide);
    }

    public static int findSubArrayWithMaxSum(int[] arr){

        int initialSum = arr[0];
        int maxSum = initialSum;
        for(int i=1; i< arr.length; i++){
            initialSum = Math.max(arr[i], initialSum + arr[i]);
            maxSum = Math.max(maxSum, initialSum);
        }
        return maxSum;
    }

   private static boolean isPalindrome(int x) {
        int num = x;

        int reverseNum = 0;
        int multiplier = 10;

        while(num > 0){
            int modulo = num % 10;

            reverseNum = modulo + reverseNum * multiplier;
            num = num / 10;
        }

       return reverseNum == x? true: false;
    }
}
