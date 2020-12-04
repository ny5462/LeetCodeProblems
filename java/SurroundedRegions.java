/** program to convert all the underlying islands of O's to X's, they should not be connected to border O's in anyway. Done using dfs from O's lying in borders, and all O's reachable from there is converted to Z's, then perform conversion of all remaining O's to X's , and convert all z's back to O's.
TC-(row*col)
**/
class Solution {
    public void solve(char[][] A) {
        if(A.length==0)return;
      for(int i=0,j=0;j<A[0].length;j++){
          if(A[i][j]=='O'){
              dfs(i,j,A);
          }
      }
        
     for(int i=A.length-1,j=0;j<A[0].length;j++){
          if(A[i][j]=='O'){
              dfs(i,j,A);
          }
     }
    for(int i=0,j=0;i<A.length-1;i++){
          if(A[i][j]=='O'){
              dfs(i,j,A);
          }
    }
    
    for(int i=0,j=A[0].length-1;i<A.length-1;i++){
          if(A[i][j]=='O'){
              dfs(i,j,A);
          }
    }
      
    for(int i=0;i<A.length;i++){
        for(int j=0;j<A[0].length;j++){
            if(A[i][j]=='O')A[i][j]='X';
        }
    } 
    
     for(int i=0;i<A.length;i++){
        for(int j=0;j<A[0].length;j++){
            if(A[i][j]=='Z')A[i][j]='O';
        }
    } 
     }
    
    public void dfs(int i, int j,char[][]A){
        if(i<0||i>=A.length||j<0||j>=A[0].length||A[i][j]!='O'){
            return;
        }
        A[i][j]='Z';
        dfs(i+1,j,A);
        dfs(i-1,j,A);
        dfs(i,j+1,A);
        dfs(i,j-1,A);
    }
}

