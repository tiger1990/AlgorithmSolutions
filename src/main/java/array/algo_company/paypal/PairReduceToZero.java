package array.algo_company.paypal;

import java.util.*;

public class PairReduceToZero {

    public static void main(String... args){

        //int arr[] = {-2, 2, 3, 7, 4, -7};
        int arr[] = {-2, 2, 3, 0, 4, -7};
        //int arr[] = {-1, 1};
        System.out.print(getTestNumberOfPairs(arr));
    }


    public static int getTestNumberOfPairs(int[] arr){

        int MAX_RANGE = 100000 - 1;
        int length = arr.length;
        if(arr.length > MAX_RANGE){
            return -1;
        }
        HashMap<Integer, Boolean> numbers = new HashMap<>();
        int completeSum = 0;

        for(int j=0; j< length; j++){
            int value = arr[j];
            if(value > MAX_RANGE){
                return -1;
            }
            numbers.put(value, false);
            completeSum+= value;
        }

        if(numbers.size() == 0){
            return -1;
        }

        if(numbers.size() ==1){
            for(Integer num: numbers.keySet()){
                if(num ==0){
                    return 1;
                }else{
                    return -1;
                }
            }
        }

        int pairs = 0;
        int sum = -1;

        if(length > 2 && completeSum ==0){
            pairs++;
        }

        for(int i=0; i<length; i++){

            int num = arr[i];
            int numToFind = 0 -(num);

            if(numToFind ==0){
                pairs++;
                numbers.put(numToFind, true);
                continue;
            }

            boolean found = numbers.containsKey(numToFind);
            if(found && numbers.get(numToFind)){
                continue;
            }

            if(found){
                pairs++;
                numbers.put(num, true);
                numbers.put(numToFind, true);
            }else{
                if(sum == -1){
                    sum = 0;
                }
                sum+= num;
                int sumToFind = 0-sum;
                if(numbers.containsKey(sumToFind)){
                    sum = 0;
                }
            }

            if(sum ==0){
                pairs++;
                numbers.put(sum, true);
                sum = 0;
            }

        }

        return pairs> MAX_RANGE? -1: pairs;
    }

    public static int getNumberOfPairs(int[] arr){

        if(arr.length > 1000000000){
            return -1;
        }
        HashMap<Integer,Boolean> numbers = new HashMap();

        int completeSum = 0;
        for(int i=0; i< arr.length; i++){
            numbers.put(arr[i],false);
            completeSum+= arr[i];
        }

        if(numbers.size() == 0){
            return -1;
        }

        if(numbers.size() ==1){
            for(Integer num:numbers.keySet()){
                if(num == 0){
                    return 1;
                }else{
                    return -1;
                }
            }
        }

        int pairs = 0;
        int sum = -1;

        if(numbers.size() > 2 && completeSum ==0){
            pairs++;
        }

        for(int j=0; j< arr.length; j++){

            int num = arr[j];
            int numToFind = 0 - (num);

            if(numToFind == 0){
                pairs++;
                numbers.put(numToFind,true);
                continue;
            }

            boolean found = numbers.containsKey(numToFind);

            if(found && numbers.get(numToFind)){
                continue;
            }

            if(found){
                pairs++;
                numbers.put(num,true);
                numbers.put(numToFind,true);
            }else {
                if(sum == -1) {
                    sum = 0;
                }
                sum += num;
                int sumToFind = 0 - sum;
                if(numbers.containsKey(sumToFind)){
                    sum = 0;
                }
            }

            if (sum == 0) {
                pairs++;
                numbers.put(sum, true);
                sum = 0;
            }
        }

        return pairs > 1000000000 ? -1 : pairs;
    }

}
