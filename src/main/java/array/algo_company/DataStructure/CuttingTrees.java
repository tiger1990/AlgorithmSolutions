package array.algo_company.DataStructure;

public class CuttingTrees {

    public static void main(String... args)
    {
        int[] trees = new int[] {1, 3, -5, 2, 7, 9, -10, 6, 12, 21, 23, -7, 34};

        int max = trees[0];

        System.out.println(max);
        for(int i = 1; i < trees.length; i++)
        {
            if(trees[i] < max)
            {
                trees[i] = -1;
            }
            else
            {
                max = trees[i];
                System.out.println(" "+trees[i]);
            }
        }

//        for(int i = 1; i < trees.length; i++)
//        {
//            if(trees[i] != -1)
//            System.out.println(" "+trees[i]);
//        }
    }
}
