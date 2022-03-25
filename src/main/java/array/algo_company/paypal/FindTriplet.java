package array.algo_company.paypal;

import java.util.Arrays;

public class FindTriplet {

    public static void main(String... args){

        int arr[] = {2,4,3,13,6,5,7};
        int size = arr.length;
        int[] triplet = checkSquareTriplet(arr,size);
        System.out.print("Exist:=  "+triplet[0]+" "+triplet[1]+" "+triplet[2]);
    }

    private static int[] checkSquareTriplet(int[] arr, int size){

        //square the number
        for(int k=0; k< size; k++){
            arr[k] = arr[k] * arr[k];
        }
        //sort array
        Arrays.sort(arr);
        int[]triplet = new int[3];

        for(int j=size-1; j>=2; j--){
            int indexL = 0;
            int indexR = j -1;

            while(indexL < indexR) {
               int sum = arr[indexL] + arr[indexR];
                if (sum == arr[j]) {
                    System.out.println(" " + arr[indexL] + " " + arr[indexR] + " " + arr[j]);
                    triplet[0] = arr[indexL];
                    triplet[1] = arr[indexR];
                    triplet[2] = arr[j];
                    break;

                } else if (sum > arr[j]){
                    indexR--;
                }else indexL++;
            }
        }
        return triplet;
    }
}
