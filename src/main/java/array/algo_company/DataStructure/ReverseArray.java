package array.algo_company.DataStructure;

public class ReverseArray
{
    public static void main(String... args)
    {
        int arr[] = new int[]{ 10, 20, 30, 40, 50, 60, 70};

        reverseArray(arr, arr.length -1);

        for(int j=0; j<arr.length; j++)
        {
            System.out.println(""+arr[j]);
        }
    }

    private static void reverseArray(int[] arr, int n)
    {
        int temp;

        for(int i=0; i<=n/2; i++)
        {
          temp = arr[i];
          arr[i] =  arr[n-i];
          arr[n-i] = temp;
        }
    }
}
