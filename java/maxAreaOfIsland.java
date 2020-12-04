/** program to find max area of an island of 1's , where 0 is water and island should be surrounded on 4 directions by water.
Done using DFS
credits- https://leetcode.com/problems/max-area-of-island/discuss/437880/Easy-to-understand-JAVA-DFS-Island-problem-based-extension-solution-with-small-changes
TC-O(m*n)
**/
class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        boolean [][]visited=new boolean[grid.length][grid[0].length];
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&visited[i][j]==false){
                        max=Math.max(max,DFS(grid,visited,i,j,0));
                    }

                }
            }
        return max;
        }
        
    
    public int DFS(int[][]grid, boolean[][]visited,int i, int j,int area){
        if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||visited[i][j]||grid[i][j]!=1){
                return area;
        }
        visited[i][j]=true;
        area++;
        area=DFS(grid,visited,i+1,j,area);
        area=DFS(grid,visited,i-1,j,area);
        area=DFS(grid,visited,i,j+1,area);
        area=DFS(grid,visited,i,j-1,area);      
        
        return area;
    
    
    }
}
