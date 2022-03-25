package array.algo_company.array;

public class MinimumDistanceBwNumber
{
    public static void main(String... args)
    {
        int array[] = new int[]{3, 5, 4, 3,7,6};
        System.out.println("Minimum Distance Between Array Index:: "+printMinimumDistance(array,3,6));
    }

    private static int printMinimumDistance(int[] arr, int x, int y){

        int MIN_DISTANCE = Integer.MAX_VALUE;
        int lastIndex = -1;

        for(int i=0; i< arr.length; i++){
            if(arr[i] == x || arr[i] == y){
                lastIndex = i;
            }
        }
        if(lastIndex == -1) { return -1; }

        for(int j=0; j<arr.length; j++){

            if(arr[j] == x || arr[j] == y){

                if(arr[lastIndex] != arr[j] && j - lastIndex < MIN_DISTANCE){

                    MIN_DISTANCE = Math.abs(j-lastIndex);
                }
                lastIndex = j;
            }
        }
        return MIN_DISTANCE;
    }
}
