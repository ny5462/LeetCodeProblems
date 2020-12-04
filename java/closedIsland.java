/** program to find number of closed islands, land is 0, water is 1, island is a piece of zero or zeroes surrounded on all sides (i.e top ,down, lef,right) by 1's. return no of islands.
Done using DFS, where border line zeroes don't contribute to island formation.
TC-O(m*n)
**/

class Solution {
    int count=0;
    public int closedIsland(int[][] grid) {
        boolean [][] visited= new boolean[grid.length][grid[0].length];
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                if(grid[i][j]==0&&!visited[i][j]==true){
                    if(DFS(grid,visited,i,j))count++;
                }

            }
        }
        return count;
    }
    
    public boolean DFS(int[][]grid, boolean[][]visited,int i,int j){  
        if(i==0||i==grid.length-1||j==0||j==grid[0].length-1){
            if(grid[i][j]==0)return false;
        }
        boolean s=true;
        if(grid[i][j]==0&&visited[i][j]==false){         
            visited[i][j]=true;
            s=s&DFS(grid,visited,i+1,j);
            s=s&DFS(grid,visited,i,j+1);
            s=s&DFS(grid,visited,i-1,j);
            s=s&DFS(grid,visited,i,j-1);

            }
        return s;
            
    }
}

