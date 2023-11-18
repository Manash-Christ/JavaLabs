public class ShareTrader {

    // Static variable to store the maximum profit
    private static int maxProfit = 0;

    // Static method to find the maximum profit
    public static int findMaxProfit(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length < 2) {
            System.out.println("Not enough stock prices to trade.");
            return 0;
        }

        maxProfit = 0;
        int n = stockPrices.length;

        // Iterate through each day as the first transaction's buying day
        for (int buyDay = 0; buyDay < n - 3; buyDay++) {
            // Iterate through each day as the first transaction's selling day
            for (int sellDay1 = buyDay + 1; sellDay1 < n - 2; sellDay1++) {
                // Calculate the profit of the first transaction
                int profit1 = stockPrices[sellDay1] - stockPrices[buyDay];

                // Iterate through each day as the second transaction's buying day
                for (int buyDay2 = sellDay1 + 1; buyDay2 < n - 1; buyDay2++) {
                    // Iterate through each day as the second transaction's selling day
                    for (int sellDay2 = buyDay2 + 1; sellDay2 < n; sellDay2++) {
                        // Calculate the total profit of the two transactions
                        int totalProfit = profit1 + (stockPrices[sellDay2] - stockPrices[buyDay2]);

                        // Update the maximum profit if the current total profit is greater
                        if (totalProfit > maxProfit) {
                            maxProfit = totalProfit;
                        }
                    }
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Example usage
        int[] stockPrices = {10, 22, 5, 75, 65, 80};
        int result = findMaxProfit(stockPrices);
        System.out.println("Maximum Profit: " + result);
    }
}
