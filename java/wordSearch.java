/** find if a word exists in a char board, done using dfs , where we manippulate board chars, when visited, and when it results in a faulty route, we restore the original char, we end the search when the path is not present , or when the final char is found.
TC-O(rows*columns)
faster way below where you convert word to char array and search for letter on that index
**/
class Solution {
   // boolean[][]visited;
    public boolean exist(char[][] board, String word) {
        char[] lett=word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    //visited=new boolean[board.length][board[0].length];
                    if(dfs(board,i,j,lett,0))return true;
                }
            }
        }return false;
        
    }
    
    public boolean dfs(char[][]board, int i, int j,char[] lett,int index){
        if(i<0||j<0||i>=board.length||j>=board[0].length||
           board[i][j]!=lett[index]||board[i][j]=='#'){
            return false;
        }
        //visited[i][j]=true;
        char t=board[i][j];
        board[i][j]='#';
        if(index==lett.length-1)return true;
        boolean res=dfs(board,i+1,j,lett,index+1)||dfs(board,i-1,j,lett,index+1)||dfs(board,i,j+1,lett,index+1)||dfs(board,i,j-1,lett,index+1);
        board[i][j]=t;
        return res;
                            
    }
}

//slower dfs below

class Solution {
   // boolean[][]visited;
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    //visited=new boolean[board.length][board[0].length];
                    if(dfs(board,i,j,word))return true;
                }
            }
        }return false;
        
    }
    
    public boolean dfs(char[][]board, int i, int j,String word){
        if(i<0||j<0||i>=board.length||j>=board[0].length||
           board[i][j]!=word.charAt(0)||board[i][j]=='#'){
            return false;
        }
        //visited[i][j]=true;
        char t=board[i][j];
        board[i][j]='#';
        if(word.length()==1)return true;
        String search=word.substring(1,word.length());
        boolean res=dfs(board,i+1,j,search)||dfs(board,i-1,j,search)||dfs(board,i,j+1,search)||dfs(board,i,j-1,search);
        board[i][j]=t;
        return res;
                            
    }
}
