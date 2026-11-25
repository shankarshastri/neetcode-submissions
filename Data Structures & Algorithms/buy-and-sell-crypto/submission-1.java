class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = l + 1;
        int profit = Integer.MIN_VALUE;
        while(r < prices.length) {
            if(prices[l] < prices[r]) {
                profit = Math.max(profit, prices[r] - prices[l]);
                r++;
            } else {
                l = r;
                r = l + 1;
            }
        }
        return Math.max(0, profit);
    }
}
