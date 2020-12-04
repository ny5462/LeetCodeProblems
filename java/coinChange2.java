/**You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Done by using 2d dp, dealing with it as a knapsack problem, where if a coin is less than the current amount being looked at, we check for two combinations, to get all possible values upto that amount. i.e when the ith coin is not included, which we can get from dp[i-1][j], and when that coin is included, which we can get by adding the amount we get by reducing the current amount by value of that count, which tells us the no of ways to get the balance amount.
credits - https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space
TC-O(nm)
**/
class Solution {
    public int change(int amount, int[] coins) {
    	// adding extra row and column for padding when amount is 0, or when no coin is seen
        int[][]dp=new int[coins.length+1][amount+1];
        dp[0][0]=1;     
        for(int i=1;i<=coins.length;i++){
            dp[i][0]=1;
            for(int j=1;j<=amount;j++){
            	// first part deals when current coin is not included, second part when it is included and is less than current amount
                dp[i][j]=dp[i-1][j]+(j>=coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
       
        return dp[coins.length][amount];
    }
}
