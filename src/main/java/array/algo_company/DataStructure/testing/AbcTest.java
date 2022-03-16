package array.algo_company.DataStructure.testing;

import java.util.HashMap;
import java.util.Map;

public class AbcTest {

    static int arr[] = new int[]{2, -2, 3, 0, 4, -7} ;


    public static void main(String... args){

       // System.out.println(solution(0));


        int sum = 0;
        System.out.println("Count of pairs is " +
                getPairsCount(arr.length,sum));


    }


    static int getPairsCount(int n, int sum)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Store counts of all elements in map hm
        for (int i=0; i<n; i++){

            // initializing value to 0, if key not found
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i],0);

            hm.put(arr[i], hm.get(arr[i])+1);
        }
        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i=0; i<n; i++)
        {
            if(hm.get(sum-arr[i]) != null)
                twice_count += hm.get(sum-arr[i]);

            // if (arr[i], arr[i]) pair satisfies the condition,
            // then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i])
            // pair is not considered
            if (sum-arr[i] == arr[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count/2;
    }


    public static int solution(int N) {
        // write your code in Java SE 8
        // write your code in Java SE 8
        int insertDigit = 5;

        int number = Math.abs(N);
        int digitLength = String.valueOf(number).length();

        int divisor = (int) Math.pow(10,digitLength - 1);

        int returnNumber = 0;


        int backDigit = 0;
        while(divisor > 0){

            int currentDigit = number / divisor;

            boolean condition = N >= 0 ? currentDigit < insertDigit : currentDigit > insertDigit;


            if(condition){

                returnNumber = backDigit + insertDigit * 10 * divisor + number;
                break;
            }
            else{
                backDigit +=  10 * divisor * currentDigit;
                number = number % divisor;
                divisor = divisor /10;
                if(divisor == 0){
                    if(N< 0) {
                        return  -1 * backDigit + insertDigit;
                    }
                    return  backDigit + insertDigit;
                }
            }

        }

        if(N< 0) {
            return  -1 * returnNumber;
        }
        return   returnNumber;
    }
}
