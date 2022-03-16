package array.algo_company.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMax_BirthdayCake_TimeConversion {

    public static void main(String... args) {

       // miniMaxSum(Arrays.asList(1, 2, 3, 4, 5, 6));

        //birthdayCakeCandles(Arrays.asList(1, 4, 3, 4, 1, 4));

        timeConversion("07:05:45PM");
    }


    public static String timeConversion(String s) {
        // Write your code here
        //07:05:45PM
        //01234567
        String arr[] = s.split(":");
        String hour = arr[0];
        String min = arr[1];
        String part = arr[2];
        String sec = part.substring(0,2);
        String ampm = part.substring(2,4);

       String conversion = "";
        if(ampm.equals("AM")){
            conversion = hour+":"+min+":"+sec;
        }else{
            int changesHour = Integer.parseInt(hour);
            changesHour += 12;
            conversion = changesHour+":"+min+":"+sec;
        }
        return conversion;
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int max = candles.get(0);
        int occurence= 0;
        for(int i=0; i< candles.size();i++){
            int candle = candles.get(i);
            if(max < candle){
                max = candle;
                occurence = 0;
            }
            if(max == candle){
                occurence+=1;
            }
        }
        System.out.println(occurence);
        return occurence;
    }


    public static void miniMaxSum(List<Integer> list) {

        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);

        long[] m = new long[arr.length];
        long sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        for(int i = 0; i < arr.length; i++){
            m[i] = sum - arr[i];
        }
        long min = m[0];
        long max = m[0];
        for(int k=1;k<arr.length;k++){
            if(m[k]<min){
                min=m[k];
            }
            if(m[k]>max){
                max=m[k];
            }
        }
        System.out.print(min + " " + max);
    }
}
