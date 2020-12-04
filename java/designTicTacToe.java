/**Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

    A move is guaranteed to be valid and is placed on an empty block.
    Once a winning condition is reached, no more moves is allowed.
    A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.

Example:

Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|

Done by maintaining a board, and after every move, check if row formation done, column formation done or diagonal formation done of that player with the move.
**/
class TicTacToe {

    /** Initialize your data structure here. */
    int[][] board;
    int len;
    public TicTacToe(int n) {
        this.board=new int[n][n];
        this.len=n-1;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col]=player;
        if(checkRow(row, player))return player;
        if(checkCol(col, player))return player;
        if(isDiagonal(row,col)){
            if(checkDiag(player))return player;
        }
        
        return 0;
    }
    
    public boolean checkRow(int row, int player){
        for(int i=0;i<board[0].length;i++){
            try{
                if(board[row][i]!=player)return false;
            }catch(NullPointerException e){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkCol(int col, int player){
        for(int i=0;i<board.length;i++){
            try{
                if(board[i][col]!=player)return false;
            }catch(NullPointerException e){
                return false;
            }
        }
        return true;
    }
    
    // checks if its a diagonal grid
    public boolean isDiagonal(int row, int col){
        if(row==col)return true;
        if((row+col)==len)return true;
        return false;
        
    }
    
    //checks for diagonal elements first from top-left to bottom right and then vice versa
    public boolean checkDiag(int player){
        boolean zig=true;
        for(int i=0;i<board.length;i++){
            try{
                if(board[i][i]!=player){
                    zig=false;
                    break;
                }
            }catch(NullPointerException e){
                zig=false;
                break;
            }
        }
        if(zig)return true;
        //if above diagonal is not possible checks for bottom left to top right
        for(int i=len,j=0;i>=0&&j<board[0].length;i--,j++){
            try{
                if(board[i][j]!=player)return false;
            }catch(NullPointerException e){
                return false;
            }
            
        }
        return true;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
