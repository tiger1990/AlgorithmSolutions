package array.algo_company.DataStructure;

//"Kadane`s Algorithm"
public class MaxSubArray
{
    public static void main(String... args)
    {
        int givenArray[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        int countSum = getTotalCount(givenArray);

        int maxSumSubArray1 = findMaxSum(givenArray,0,givenArray.length -1,countSum);  //O(n^2)
        System.out.println("Max Sum:: "+maxSumSubArray1);


        int maxSumSubArray2 = findMaxSum(givenArray);// O(n)
        System.out.println("Max Sum:: "+maxSumSubArray2);


    }

    private static int getTotalCount(int[] givenArray) {

        int countSum =0;
        for(int i=0; i<givenArray.length;i++)
        {
            countSum+=   givenArray[i];
        }
        return countSum;
    }

    //Kadane`s algo
    private static int findMaxSum(int[] givenArray)
    {
        int initialSum =0;
        int maxSum = Integer.MIN_VALUE;

        int size = givenArray.length;

        for(int i=0; i<size; i++)
        {
            initialSum = initialSum + givenArray[i];

            if(initialSum >  maxSum)
            {
               maxSum = initialSum;
            }

            if(initialSum < 0)
            {
                initialSum = 0;
            }
        }
        return maxSum;
    }

    private static int findMaxSum(int[] givenArray, int left, int right,int countSum)
    {
        if(left >= right)
        {
            return countSum;
        }

        int withoutFirst = findMaxSum(givenArray,left + 1,right, countSum - givenArray[left]);

        int withOutLast = findMaxSum(givenArray,left,right - 1,countSum - givenArray[right]);

        int maxSum = Math.max(countSum, Math.max(withoutFirst,withOutLast));

        return maxSum;
    }



}
