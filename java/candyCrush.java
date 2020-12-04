/**This question is about implementing a basic elimination algorithm for Candy Crush.

Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent different types of candies. A value of board[i][j] = 0 represents that the cell at position (i, j) is empty. The given board represents the state of the game following the player's move. Now, you need to restore the board to a stable state by crushing candies according to the following rules:

    If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same time - these positions become empty.
    After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these candies will drop until they hit a candy or bottom at the same time. (No new candies will drop outside the top boundary.)
    After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
    If there does not exist more candies that can be crushed (ie. the board is stable), then return the current board.

You need to perform the above rules until the board becomes stable, then return the current board.
Input:
board = 
[[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]

Output:
[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],[410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]
Done by maintaining a boolean value which checks if another loop is necessary. Within the loop, we first flag the boolean to false, we then iterate and see the value at the corresponding grid, if its 0, we continue towards another grid. if the value is non zero, we store it and then we traverse every column looking for the next elements and see if they match this element. if they do, we start another loop from this grid till we continue to see the same value in the column, and change that value to -value. we do the same for the row iteration.
after all the values that were continous were flagged, we do the gravity step, by pushing all the positive values on top of the negative values, and replace the grids left by them on top to 0.
credits - https://leetcode.com/problems/candy-crush/discuss/113914/15-ms-Short-Java-Solution-Mark-crush-with-negative-value
**/

class Solution {
    public int[][] candyCrush(int[][] board) {
      int N=board.length;
      int M = board[0].length;
      boolean found =true;
      while(found){
          found=false;
          for(int i=0;i<N;i++){
              for(int j=0;j<M;j++){           
              //we take abs value to avoid conflict in row checks after column checks have been done      
                  int val=Math.abs(board[i][j]);
                  if(val==0)continue;
                  if(j<M-2 && Math.abs(board[i][j+1])==val && Math.abs(board[i][j+2])==val){
                      int ind=j;
                      found=true;
                      while(ind<M && Math.abs(board[i][ind])==val)board[i][ind++]=-val;
                  }
                  if(i<N-2 && Math.abs(board[i+1][j])==val && Math.abs(board[i+2][j])==val){
                      int ind=i;
                      found=true;
                      while(ind<N && Math.abs(board[ind][j])==val)board[ind++][j]=-val;
                  }
              }
          }
          // gravity step column wise, replace top by zero
          for(int j=0;j<M;j++){
              int ind=N-1;
              for(int i=N-1;i>=0;i--){
                  if(board[i][j]>0){
                      board[ind--][j]=board[i][j];
                  }
              }
              
            for(int k=ind;k>=0;k--){
                board[k][j]=0;
            }
          }
      }  
        return board;
    }
}


