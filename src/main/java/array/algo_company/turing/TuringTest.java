package array.algo_company.turing;

import java.util.Arrays;

public class TuringTest {

    public static void main(String... args){

//        int[] num = {1, 2, 4, 6, 3, 7, 8};
//        int missingNumber = returnMissing(num);
//        if(missingNumber != -1){
//            System.out.print("\nMissingNumber: "+missingNumber);
//        }

        String someString = "abc";
        //System.out.print("Reverse is :"+returnReverse(someString));

         sumBinary(1011, 1001);
    }


    public static void sumBinary(long binary1, long binary2){

        int carry = 0;
        int index = 0;
        int[] sumArray = new int[10];

        while(binary1 != 0 || binary2 != 0){

            sumArray[index] = (int) (carry + (binary1 % 10 + binary2 % 10)) % 2;

            carry = (int) ((binary1 % 10 + binary2 % 10 + carry)/2);

            binary1 = binary1 / 10;
            binary2 = binary2 / 10;

            index++;
        }

        if(carry != 0){
            sumArray[index] = carry;
        }


        while(index >= 0){
            System.out.print(sumArray[index--]);
        }
    }


    public static String returnReverse(String someString){

        int length= someString.length();
        int index = length -1;
        char[] chars = new char[length];

        int charIndex = 0;
        while(index != -1){

            chars[charIndex] = someString.charAt(index);
            index--;
            charIndex++;
        }
        return new String(chars);
    }

    private static int returnMissing(int[] numberArray){

        int missingNumber= -1;
        Arrays.sort(numberArray);

        System.out.print("\nlength: "+ numberArray.length);
        System.out.print("\nlength-1: "+ (numberArray.length-1));

        int prevDiff;
        for(int index=0; index<numberArray.length-1; index++){

            //System.out.print("\nindex: "+index);

            int nextIndex = index + 1;
            int currentNum = numberArray[index];
            int nextNum = numberArray[nextIndex];

            prevDiff = nextNum - currentNum;

            if(prevDiff > 1) {
                missingNumber = numberArray[index]+1;
            }
        }

        return missingNumber;
    }
}

