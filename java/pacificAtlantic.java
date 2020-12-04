/**
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

    The order of returned grid coordinates does not matter.
    Both m and n are less than 150.

 

Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
Done by dfs over all boundary points of matrix to check and reach all same level and high level points reachable for them, if such a point can be reached from border points of both atlantic and pacific coastline, we include them.
TC-O(M*N)
SC-2(M*N)
**/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if(matrix.length==0)return ans;
        boolean [][] pacific=new boolean[matrix.length][matrix[0].length];
        boolean [][] atlantic = new boolean[matrix.length][matrix[0].length];
        
        int row = matrix.length;
        int col = matrix[0].length;
        int min= Integer.MIN_VALUE;
        for(int i=0;i<row;i++){
            dfs(i,0,min,matrix,pacific);
            dfs(i,col-1,min,matrix,atlantic);
        }
        
        for(int j=0;j<col;j++){
            dfs(0,j,min,matrix,pacific);
            dfs(row-1,j,min,matrix,atlantic);
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j]&& atlantic[i][j]){
                    List<Integer> l =new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
    
     public void dfs(int i, int j, int prev,int[][] matrix, boolean[][] visited){
         if(i<0||i>=visited.length|| j<0||j>=visited[0].length|| matrix[i][j]<prev||visited[i][j]){
             return;
         }
         visited[i][j]=true;   
         int val=matrix[i][j];
         
         dfs(i+1,j,val,matrix,visited);
         dfs(i-1,j,val,matrix,visited);
         dfs(i,j+1,val,matrix,visited);
         dfs(i,j-1,val,matrix,visited);
     }
}


//faster way with one visited array
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if(matrix.length==0)return ans;
        char [][] visited=new char[matrix.length][matrix[0].length];
        
        
        int row = matrix.length;
        int col = matrix[0].length;
        int min= Integer.MIN_VALUE;
        for(int i=0;i<row;i++){
            dfs(i,0,min,matrix,'P' , visited, ans);
            dfs(i,col-1,min,matrix,'A', visited, ans);
        }
        
        for(int j=0;j<col;j++){
            dfs(0,j,min,matrix,'P',visited,ans);
            dfs(row-1,j,min,matrix, 'A', visited, ans);
        }
        
        
        return ans;
    }
    
     public void dfs(int i, int j, int prev,int[][] matrix,char c, char[][] visited, List<List<Integer>> ans){
         if(i<0||i>=visited.length|| j<0||j>=visited[0].length|| matrix[i][j]<prev||visited[i][j]=='X'||visited[i][j]==c){
             return;
         }
         if((c=='A' && visited[i][j]=='P')||(c=='P' && visited[i][j]=='A')){
             visited[i][j]='X';
             ans.add(Arrays.asList(i,j));
         }else{
             visited[i][j]=c;
         } 
         int val=matrix[i][j];   
         dfs(i+1,j,val,matrix,c,visited,ans);
         dfs(i-1,j,val,matrix,c,visited,ans);
         dfs(i,j+1,val,matrix,c,visited,ans);
         dfs(i,j-1,val,matrix,c,visited,ans);
     }
}
