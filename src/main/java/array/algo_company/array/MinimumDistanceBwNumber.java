package array.algo_company.array;

public class MinimumDistanceBwNumber
{
    public static void main(String... args)
    {
        int array[] = new int[]{3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};

        System.out.println("Minimum Distance Between Array Index:: "+printMinDistance(array,3,6));

    }

    private static int printMinDistance(int[] array,int x, int y)
    {
        int minDistance = Integer.MAX_VALUE;
        int prevIndex = -1;

      for(int i=0; i< array.length; i++)
      {
          if(array[i] == x || array[i] == y)
          {
              prevIndex = i;
          }
      }
      if(prevIndex == -1) { return -1; }

        for(int j=0; j< array.length; j++)
        {
            if(array[j] == x || array[j] == y)
            {
               if(array[prevIndex] != array[j]  && (j-prevIndex) < minDistance)
               {
                   minDistance = j-prevIndex;
                   prevIndex = j;
               }
               else
               {
                   prevIndex = j;
               }
            }
        }

        return minDistance;
    }
}
