/** program to find the maximum profit by selling, given an array of stocks where buying comes before selling at all costs. 
Approach 1 using Dynamic programming iterating through an array via brute force to try for all possible combinations, and sending the maximum profit. Slow Brute force solution.
TC--O(N(N+1)/2)

Approach 2 one pass, using variables to store min price as maxprofit as you iterate, change them.
TC-O(N)
**/
class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len==1||len==0)return 0;
        int [] ROI =new int[len];
        ROI[0]=0;
        int count=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                int diff=prices[j]-prices[i];
                if(diff>0&&diff>ROI[count]){
                    ROI[++count]=diff;
                }
            }
        }
        return ROI[count]>=0?ROI[count]:0;
    }
}

/** approach 2 credits to https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
**/
class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len==1||len==0)return 0;
        int max=0;
        int minPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice)minPrice=prices[i];
            else if(prices[i]-minPrice>max)max=prices[i]-minPrice;
        }
        return max;
}
}
