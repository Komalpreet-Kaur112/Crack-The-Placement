package Arrays;

// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

// Solution
class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int left = 0; //buy
        int right = 1; //sell
        while(right < prices.length){
            if(prices[left] < prices[right]){
                // buy = prices[left];
                int profit = prices[right] - prices[left];
                maxP = Math.max(maxP, profit);
                right++;
            }
            else{//prices[left] > prices[right]
                left = right;
                right++;
            }
            
        }
        return maxP;
    }
}