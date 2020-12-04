/** program to count no of ways to reach n stairs, with possibilities of either of either 1 or 2 steps at a time. Done using recursion with memoization or dynamic programming.
TC-O(N)
ccredits-https://leetcode.com/problems/climbing-stairs/solution/
**/
class Solution {
    public int climbStairs(int n) {
        int[] staircase=new int[n+1];
        return steps(0,n,staircase);

        
    }
    public int steps(int i , int n, int[] memo){
        if(i>n)return 0;
        if(i==n)return 1;
        if(memo[i]>0)return memo[i];
        memo[i]=steps(i+1,n,memo)+steps(i+2,n,memo);
        return memo[i];
    }
}
/** DP approach**/
class Solution {
    public int climbStairs(int n) {
        int[] staircase=new int[n+1];
        if(n==1)return 1;
        staircase[1]=1;
        staircase[2]=2;
        for(int i=3;i<=n;i++){
            staircase[i]=staircase[i-1]+staircase[i-2];
        }
        return staircase[n];
}
}
