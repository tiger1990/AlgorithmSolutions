package array.algo_company.leetcode;

public class MaximumProfitForBuySell {

    public static void main(String[] args) {

        int[] stockPrice = new int[]{7, 2, 5, 6, 1, 3, 5, 8};

        System.out.println("Maximum Profit is:" + maxProfit1(stockPrice));
        System.out.println("Maximum Profit is:" + maxProfit2(stockPrice));
    }

    public static int maxProfit1(int[] prices) {
        int minBuyPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];

            int profit = currentPrice - minBuyPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (currentPrice < minBuyPrice) {
                minBuyPrice = currentPrice;
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] stockPrice) {
        int maxProfit = 0;
        int buyPrice = stockPrice[0];
        for (int i = 1; i < stockPrice.length; i++) {
            int profit = stockPrice[i] - buyPrice;
            maxProfit = Integer.max(maxProfit, profit);

            buyPrice = Integer.min(buyPrice, stockPrice[i]);
        }
        return maxProfit;
    }
}
