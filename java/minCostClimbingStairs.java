/**program to find minimum cost of climbing stairs given cost at every step.
Done using dynamic programming bottom up approach. 
TC-O(N)
credits- https://leetcode.com/problems/min-cost-climbing-stairs/solution/
**/


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] travel=new int[cost.length];
        travel[0]=cost[0];
        travel[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            travel[i]=Math.min(travel[i-1]+cost[i],travel[i-2]+cost[i]);
        }
        return Math.min(travel[cost.length-1],travel[cost.length-2]);
        
    }
    
    
}
