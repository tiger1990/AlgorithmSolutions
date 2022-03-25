package array.algo_company.paypal;

import java.util.HashMap;

public class InsertDigitGetMax {

    public static void main(String... args){

        int givenNumber = 267;
        System.out.print("Exist:=  "+getNum(givenNumber));

        System.out.print("\nExist:=  "+insertDigitGetMax(5,givenNumber));

        int[] array = {5, -1, 3, 0, 4, -7};
        System.out.print("\nZeroPairsSubarray:=  "+solution(array));
    }


    public static int solution(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {

            sum += A[i];

            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    private static int insertDigitGetMax(int digit, int number){

        int num = number;

        //case if number is 0
        if(number == 0){
            return digit * 10;
        }
        //-1 if number is negative else 1
        int negative = num / Math.abs(num);

        //get the absolute value of given number num
        num = Math.abs(num);
        int position = 1;
        int MaxValue = Integer.MIN_VALUE;

        // count the number of digits in the given number.
        int counter = 0;
        int n = num;
        while(n > 0){
            counter++;
            n = n/ 10;
        }

        // loop to place digit at every possible position in the number,
        // and check the obtained value.
        for(int i=0; i<= counter; i++){

            int newValue = ((num/position) * (position * 10)) + (digit * position) + (num % position);
            // number obtained after inserting digit.

            int finalValue = newValue * negative;
            if(finalValue > MaxValue ){
                MaxValue = finalValue;
            }
            position = position * 10;
        }

        return  MaxValue;
    }

    private static int getNum(int N){
        int digit = 5;
        int num = N;
        // edge case
        if (num == 0)
        {
            return digit * 10;
        }

        // -1 if num is negative number else 1
        int negative = num / Math.abs(num);
        // get the absolute value of given number
        num = Math.abs(num);
        // maximum number obtained after inserting digit.
        int maxVal = Integer.MIN_VALUE;
        int position = 1;

        // count the number of digits in the given number.
        int counter = 0;
        int n = num;
        while (n > 0) {
            counter++;
            n = n / 10;
        }

        // loop to place digit at every possible position in the number,
        // and check the obtained value.
        for (int i = 0; i <= counter; i++)
        {
            int newVal = ((num / position) * (position * 10)) + (digit * position) + (num % position);

            // if new value is greater the maxVal
            if (newVal * negative > maxVal)
            {
                maxVal = newVal * negative;
            }

            position = position * 10;
        }

        return maxVal;
    }
}
