/**Let's play the minesweeper game (Wikipedia, online game)!

You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

    If a mine ('M') is revealed, then the game is over - change it to 'X'.
    If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
    If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
    Return the board when no more squares will be revealed.

 

Example 1:

Input: 

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

Output: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:
Done ny using bfs and following game rules , setting up a function that counts no of bombs in the vicinity.
TC-O(M*N)
**/
class Solution {
    int[][]dir={{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        
        boolean[][] seen = new boolean[board.length][board[0].length];
        
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
                           
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{click[0],click[1]});
        seen[click[0]][click[1]]=true;
        
        while(!q.isEmpty()){
            int []val=q.poll();
            int numMines=getBombs(board,val[0],val[1]);
            if(numMines==0){
                board[val[0]][val[1]]='B';
                for(int[] pos: dir){
                    int row=pos[0]+val[0];
                    int col=pos[1]+val[1];
                    if(row>=0&&row<board.length&&col>=0&&col<board[0].length&&!seen[row][col]&&board[row][col]=='E'){
                        q.add(new int[]{row,col});
                        seen[row][col]=true;
                    }
                }
            }else{
                board[val[0]][val[1]]=(char)(numMines+'0');
            }      
            
        }return board;
    }
    
    public int getBombs(char[][]board, int i, int j){
        int count=0;
        for(int [] val:dir){
            int row=i+val[0];
            int col=j+val[1];
            if(row>=0&&row<board.length&&col>=0&&col<board[0].length){
                count+=board[row][col]=='M'?1:0;
            }
        }
        return count;
    }
                           
}
