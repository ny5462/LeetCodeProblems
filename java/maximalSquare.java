/**Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
Done using dp by storing in each cell the max area possile with that cell acting as the bottom right corner of a square. we check for similar cell values on top, left side and diagonal top left of each cell to find all the cells have same value. if the value is same we check for minimum value of all 3 , as they can be limiting factor in forming bigger squares as each of those adjacent cells was the bottom right corner for a square that preceded the current one.
TC-O(m*n)
**/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0)return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max=0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=1;
                    max=Math.max(max,dp[i][j]);
            }
        }
        }
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                char val=matrix[i][j];
                if(i==0||j==0){
                    continue;
                }else if(val=='1' && val==matrix[i-1][j] && val==matrix[i][j-1]&& val==matrix[i-1][j-1]){
                    dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                    max=Math.max(dp[i][j],max);
                }else{
                    continue;
                }
                    
                }
            }
    
        return max*max;
        }
    }

