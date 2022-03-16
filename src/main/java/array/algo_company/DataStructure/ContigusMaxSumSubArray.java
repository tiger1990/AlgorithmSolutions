package array.algo_company.DataStructure;

public class ContigusMaxSumSubArray {

    public static void main(String... args)
    {

        int abc[] = new int[]{ -2,-3,4, -1, -2, 1, 5, -3};

        printMaxSum(abc);
        //getMaxSum(abc);
    }

    private static void printMaxSum(int[] abc)
    {
        int MAX_SUM_SO_FAR = 0;
        int MAX_END_HERE = 0;
        int start =0; int s =0;
        int end =0;

        for(int i = 0; i < abc.length; i++)
        {

            MAX_END_HERE = MAX_END_HERE + abc[i];

            if(MAX_SUM_SO_FAR < MAX_END_HERE)
            {
                MAX_SUM_SO_FAR = MAX_END_HERE;
                start = s;
                end = i;
            }

            if(MAX_END_HERE < 0)
            {
                MAX_END_HERE = 0;
                s = i + 1;
            }
        }
        System.out.println("MAX_SUM  : "+MAX_SUM_SO_FAR);
        System.out.println("START INDEX  : "+start);
        System.out.println("END INDEX  : "+end);

    }

    private static void getMaxSum(int[] abc)
    {
        int PREVIOUS_MAX_SUM = Integer.MIN_VALUE;;

        int sum =0;

        for(int i = 0; i < abc.length; i++)
        {
            sum += abc[i];

            if(sum < 0) {

                sum = 0;
                continue;
            }

            if(sum > PREVIOUS_MAX_SUM)
            {
                PREVIOUS_MAX_SUM =  sum;
            }

        }
        System.out.println(" Maximum Sum : "+PREVIOUS_MAX_SUM);
    }
}
