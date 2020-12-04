/** program to find the shortest bridge between 2 islands of 1 in a 2d matrix, done by using dfs first, followed by bfs, first we traverse island and add its elements to queue, and mark it as visited , then we do bfs with island 1 elementsin queue, and we keep on adding untraversed path as -1 to queue, unless we reach the first 1, that belongs to island 2.
TC-O(rows*cols)
credits- for amazing approach to https://leetcode.com/sand91/
**/
class Solution {
    public int shortestBridge(int[][] A) {
       Queue<int[]> q=new LinkedList<>();
        boolean found=false;
       for(int i=0;i<A.length;i++){
           for(int j=0;j<A[0].length;j++){
               if(A[i][j]==1){
                   dfs(i,j,A,q);
                   found =true;
                    break;
               }
               
           }
           if(found)break;
       }
        
        int res=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] grid=q.poll();
                int i=grid[0];
                int j=grid[1];
                if(isValid(i+1,j,A)){
                    if(A[i+1][j]==1)return res;
                    A[i+1][j]=-1;
                    q.add(new int[]{i+1,j});
                }
                if(isValid(i-1,j,A)){
                    if(A[i-1][j]==1)return res;
                    A[i-1][j]=-1;
                    q.add(new int[]{i-1,j});
                }
                if(isValid(i,j-1,A)){
                    if(A[i][j-1]==1)return res;
                    A[i][j-1]=-1;
                    q.add(new int[]{i,j-1});
                }
                if(isValid(i,j+1,A)){
                    if(A[i][j+1]==1)return res;
                    A[i][j+1]=-1;
                    q.add(new int[]{i,j+1});
                }
            }
            res++;
        }    
        return -1;
    
    }
    
    public boolean isValid(int i, int j,int [][]A){
        return i>=0&&i<A.length&&j<A[0].length&&j>=0&&A[i][j]!=-1;
    }
    
    public void dfs(int i, int j,int[][]A,Queue<int[]> q){
        if(i<0||i>=A.length ||j<0||j>=A[0].length||A[i][j]!=1){
            return;
        }
        A[i][j]=-1;
        q.add(new int[]{i,j});
        dfs(i+1,j,A,q);
        dfs(i-1,j,A,q);
        dfs(i,j+1,A,q);
        dfs(i,j-1,A,q); 
        
    }
}
