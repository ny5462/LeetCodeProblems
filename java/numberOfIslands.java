/** program to find no of islands , where 1 is land, 0 is water. Done using DFS.
credits-https://leetcode.com/problems/number-of-islands/discuss/439897/Java%3A-Runtime%3A-1-ms-faster-than-100.00-of-Java-online-submissions-with-simple-explanation
**/

class Solution {
    public int numIslands(char[][] grid) {
      //  boolean[][]visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    DFS(grid,i,j);
                    
                }
            }
        }
        return count;
    }
    
    public void DFS(char [][]grid,int i, int j){
         if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j]='0';
         DFS(grid,i+1,j);
         DFS(grid,i-1,j);
         DFS(grid,i,j+1);
         DFS(grid,i,j-1);
        }
         
        
        
    
}
