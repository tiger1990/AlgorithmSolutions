package array.algo_company.leetcode;

public class MaximumProfitForBuySell {

    public static void main(String[] args) {

        int[] stockPrice = new int[]{7, 2, 5, 6, 1, 3, 5, 8};

        int maxProfit = 0;
        int buyPrice = stockPrice[0];
        for (int i = 1; i < stockPrice.length; i++) {
            int profit = stockPrice[i] - buyPrice;
            maxProfit = Integer.max(maxProfit, profit);

            buyPrice = Integer.min(buyPrice, stockPrice[i]);
        }

        // In this case maximum profit is when stock purchased at price: 1 and sell at 8
        System.out.println("Maximum Profit is:" + maxProfit);
    }
}
