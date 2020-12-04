/**
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Example 3:

Input: coins = [1], amount = 0
Output: 0

Example 4:

Input: coins = [1], amount = 1
Output: 1

Example 5:

Input: coins = [1], amount = 2
Output: 2
Done by using dynamic programming in bottom up approach where, we first create memo for given amount + 1 size . i.e each index representing the amount upto that index. We then fill them with a value greater than actual amount. Now, for every index, we iterate through all the coins, and try to find the amount that can be filled with fewest number of coins, for that, we go through all the coins, and find the coin which yields the minimum by subtracting the coin amount by actual amount. That would give us the minimum coins required for the balance amount.
TC-O(number coins * amount)
**/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]>i){
                    continue;
                }else{
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];   
    }
}
