/**Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
Done by using dynamic programming. where dp[i][j]= subarray that starts at A[i] and B[j] where if A[i]==B[j] dp[i][j]=dp[i+1][j+1]+1
because we look for a match 1 index ahead as well. This is a bottom up approach
TC-O(a.length*b.length)
**/
class Solution {
    public int findLength(int[] A, int[] B) {
    	   // dp stores the element at ith index of a, jth index of b
           int dp[][]=new int[A.length][B.length];
           int max=0;       
           // start from last indices 
           for(int i=dp.length-1;i>=0;i--){
               for(int j=dp[0].length-1;j>=0;j--){
                   // if chars match and it is the last index of at least one of the arrays
                   if(A[i]==B[j]){
                       if(j==B.length-1 || i==A.length-1){
                           dp[i][j]=1;
                           max=Math.max(max,dp[i][j]);
                       }
                       // we find if there is a match at further indices as well and add 1 to it.
                       else{
                           dp[i][j]=dp[i+1][j+1]+1;
                           max=Math.max(max,dp[i][j]);
                       }
                   }
               }
           }
            return max;
    }
}
