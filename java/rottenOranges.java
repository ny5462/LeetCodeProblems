/** program to find in how many days or steps will the all the oranges in grid will be rotten, whre rotten oragne is given by 2, fresh by 1, and rotten orange rots every orange next to it, 4 directionally. Done using BFS will mutiple possible starting points till entire oranges rott.
TC-O(row*col)
credits -https://leetcode.com/yaronmax/
**/
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new ArrayDeque<>();
        int fresh=0;
       for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]==2){
                   q.add(new int[]{i,j});
               }
               else if(grid[i][j]==1)fresh++;
           }
       }
        int count=0;
        while(fresh!=0 && !q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] loc=q.poll();
                int row=loc[0];
                int col=loc[1];
                if(row>0&&grid[row-1][col]==1){
                    grid[row-1][col]=2;
                    q.add(new int[]{row-1,col});
                    fresh--;
                }
                if(row<grid.length-1&&grid[row+1][col]==1){
                    grid[row+1][col]=2;
                    q.add(new int[]{row+1,col});
                    fresh--;
                }
                if(col>0&&grid[row][col-1]==1){
                    grid[row][col-1]=2;
                    q.add(new int[]{row,col-1});
                    fresh--;
                }
                if(col<grid[0].length-1&&grid[row][col+1]==1){
                    grid[row][col+1]=2;
                    q.add(new int[]{row,col+1});
                    fresh--;
                }
                }
            count++;
            
        }
        return fresh==0?count:-1;
    }
}
