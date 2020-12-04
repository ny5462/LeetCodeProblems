/**Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
Done using HashSet of HashSet of Integer, where every integer represents a grid, in a manner such that translation retains the shape. Applying dfs and storing the shape as hashset of integer, we count unique such hashsets and display the answer
TC-O(R*C)
credits for translation formula as Integer- https://leetcode.com/problems/number-of-distinct-islands/solution/
**/
class Solution {
    
    Set<HashSet<Integer>> set=new HashSet<>();
    public int numDistinctIslands(int[][] grid) {  
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    HashSet<Integer> list=new HashSet<>();
                    dfs(i, j, grid,list,i, j);               
                    System.out.println(list);
                    set.add(list);             
                }
            }
        }
        System.out.println(set);
        return set.size();
    }
    
    public void dfs(int i, int j, int[][]grid, Set<Integer> list, int minrow, int mincol){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0){
            return ;
        }
        //creating shape main task representing shape as integer
        list.add((i-minrow)*2*grid[0].length+(j-mincol));
        grid[i][j]=0;
       
        dfs(i+1,j,grid,list,minrow,mincol);
        dfs(i-1,j,grid,list,minrow,mincol);
        dfs(i,j+1,grid,list,minrow,mincol);
        dfs(i,j-1,grid,list,minrow,mincol);
        
         
    }
    
}/** much faster way using stringbuilders and directions as shape will be maintain via directions as well, they key is to keep a specific direction for backtracking as well at the end, otherwise same string for different patterns may be repeated.
credits- https://leetcode.com/problems/number-of-distinct-islands/discuss/108475/Java-very-Elegant-and-concise-DFS-Solution(Beats-100)
**/

class Solution {
    
    Set<String> set=new HashSet<>();
    public int numDistinctIslands(int[][] grid) {  
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    StringBuilder sb=new StringBuilder();
                    dfs(i, j, grid,sb,"o");               
                    set.add(sb.toString());             
                }
            }
        }
    
        return set.size();
    }
    
    public void dfs(int i, int j, int[][]grid, StringBuilder sb, String dir){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0){
            return ;
        }
        //creating shape main task representing shape as integer
        sb.append(dir);
        grid[i][j]=0;
       
        dfs(i+1,j,grid,sb,"d");
        dfs(i-1,j,grid,sb,"u");
        dfs(i,j+1,grid,sb,"r");
        dfs(i,j-1,grid,sb,"l");
        sb.append("b");
         
    }
    
}
