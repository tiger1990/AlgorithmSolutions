package array.algo_company.DataStructure;

class Solution {

    public static void main(String... args)
    {
        int A[] = new int[] {2,3,4,1,4,5,4};

        System.out.println(countWays(A));
    }

    public static int countWays(int[] arr)
    {
      int countWays = 0;
      for(int i=1; i< arr.length; i++)
      {
          if(arr[i-1] > arr[i])
          {
              if(countWays != 0) return countWays;

              if(i==1 || arr[i-2] <= arr[i])
                  countWays++;

              if(i == arr.length -1 || arr[i-1] <= arr[i+1])
                  countWays++;

              if(countWays ==0) return countWays;
          }

      }

      return countWays == 0? arr.length : countWays;
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        int countWays = 0;

        if(A != null && A.length != 1)
        {
            boolean[] startHere = new boolean[A.length];
            boolean[] endHere   = new boolean[A.length];
            endHere[0] = true;
            startHere[A.length -1] = true;

            int j = A.length -2;

            for(int i=1; i< A.length; i++)
            {
                endHere[i] = endHere[i-1] & (A[i-1] <= A[i]);
                startHere[j] = startHere[j+1] & (A[j] <= A[j+1]);
                j--;
            }

            for(int i=0; i< A.length; i++)
            {
                boolean leftSorted = true;
                boolean rightSorted = true;

                if(i-1 >= 0)
                {
                    leftSorted = endHere[i -1];
                }
                if(i + 1 < A.length)
                {
                    rightSorted = startHere[i+1];
                }

                if(leftSorted && rightSorted)
                {
                    if(i-1 >= 0 && i+1 < A.length)
                    {
                        if(A[i-1] <= A[i+1])
                        {
                            countWays++;
                        }
                    }
                    else
                    {
                        countWays++;
                    }
                }
            }
        }
        return countWays;
    }
}