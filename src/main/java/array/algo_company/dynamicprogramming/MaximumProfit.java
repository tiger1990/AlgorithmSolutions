package array.algo_company.dynamicprogramming;

public class MaximumProfit
{
   // KNAPSACK
   public static void main(String... args)
   {
       /**
        * Items: { Apple, Orange, Banana, Melon }
        * Weight: { 2, 3, 1, 4 }
        * Profit: { 4, 5, 3, 7 }
        * Knapsack capacity: 5Items
        *
        */

       int[] profits = {1, 6, 10, 16, 4, 6, 8, 12};
       int[] weights = {1, 2, 3,   5, 2, 3, 1, 4};
       int knapSackCapacity = 8;

       int maxProfit = solveMaxProfit(profits,weights,knapSackCapacity);

       System.out.println("MAX PROFIT:: "+maxProfit);
   }

    private static int solveMaxProfit(int[] profits, int[] weights, int knapSackCapacity)
    {
        Integer[][]dp = new Integer[profits.length][knapSackCapacity+1];
        return findMaxProfit(dp,profits, weights, knapSackCapacity,0);
    }

    private static int findMaxProfit(Integer[][] dp, int[] profits, int[] weights, int knapSackCapacity, int currentIndex)
    {
        if(currentIndex < 0 || knapSackCapacity <=0 || currentIndex >= profits.length)
        {
            return 0;
        }
        if(dp[currentIndex][knapSackCapacity] != null )
        {
            return dp[currentIndex][knapSackCapacity];
        }

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn’t process this

        int profit = 0;

        if(weights[currentIndex] <= knapSackCapacity)
        {

           profit = profits[currentIndex] + findMaxProfit(dp, profits,weights,
                   knapSackCapacity - weights[currentIndex], currentIndex +1);

           int profit1 = findMaxProfit(dp, profits,weights, knapSackCapacity , currentIndex +1);

            dp[currentIndex][knapSackCapacity] = Math.max(profit,profit1);

            return dp[currentIndex][knapSackCapacity];
        }

        return profit;
    }
}
