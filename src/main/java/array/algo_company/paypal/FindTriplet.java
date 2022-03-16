package array.algo_company.paypal;

import java.util.Arrays;

public class FindTriplet {

    public static void main(String... args){

        int arr[] = {2,4,3,13,6,5,7};
        int size = arr.length;
        boolean isExist = checkSquareTriplet(arr,size);
        System.out.print("Exist:=  "+isExist);

    }


    private static boolean checkSquareTriplet(int[] arr, int size) {

        for(int i=0; i<size;i++){
            arr[i] = arr[i] * arr[i];
        }

        //sort
        Arrays.sort(arr);

        for(int j=size-1; j>=2; j--){

            int indexL = 0;
            int indexR = j-1;

            while(indexL < indexR){

                if((arr[indexL] + arr[indexR]) == arr[j]){
                    return true;
                }

                if(arr[indexL] + arr[indexR] < arr[j]){
                    indexL ++;
                }else indexR--;

            }
        }
        return false;
    }
}
