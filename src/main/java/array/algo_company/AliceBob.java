package array.algo_company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AliceBob {


public static void main(String... args)
{
   int a[]= {6, 1, 4, 6, 3, 2, 7, 4};
   int output = function(a, 2, 2);
   System.out.println(output);
}

    public static int function(int[]A, int k, int l)
 {
    int totalOfKAndL = 0;

    if( (k+l) > A.length)
    {
        return -1;
    }

    Integer[] a = Arrays.stream(A).boxed().toArray(Integer[]::new);

    Integer[] maxAndStartingIndex = getMaxContiguosFromArray(a, k);
    totalOfKAndL+=maxAndStartingIndex[0];
        System.out.println(maxAndStartingIndex[0]);
    Integer[] leadingElements = Arrays.copyOfRange(a, 0, maxAndStartingIndex[1]);
    Integer[] trailingElements = Arrays.copyOfRange(a, (maxAndStartingIndex[1]+k), a.length);

    List<Integer> mergedLeadingAndTrailingElements = new ArrayList(Arrays.asList(leadingElements));
        mergedLeadingAndTrailingElements.addAll(Arrays.asList(trailingElements));
    Integer[] mergedLeadingAndTrailingElementsArray =  mergedLeadingAndTrailingElements.toArray(new Integer[0]);

    maxAndStartingIndex = getMaxContiguosFromArray(mergedLeadingAndTrailingElementsArray, l);
        System.out.println(maxAndStartingIndex[0]);
    return totalOfKAndL+=maxAndStartingIndex[0];
       // System.out.println(totalOfKAndL);
}

    static Integer[] getMaxContiguosFromArray(Integer[] a, int numberOrElements){
        int sumForFirst = 0;
        int sumForFirstPrev = 0;
        int startingIndexForK = 0;
        Integer[] maxAndStartingIndex = new Integer[2];
        for(int i = 0; i < a.length; i++){
            if(i <= a.length - numberOrElements) {
                for (int j = i; j < i + numberOrElements; j++) {
                    sumForFirst += a[j];
                }
            }

            if(sumForFirst >  sumForFirstPrev) {
                sumForFirstPrev = sumForFirst;
                startingIndexForK = i;

            }
            sumForFirst = 0;
        }
        maxAndStartingIndex[0] = sumForFirstPrev;
        maxAndStartingIndex[1] = startingIndexForK;
        return maxAndStartingIndex;
    }
}
