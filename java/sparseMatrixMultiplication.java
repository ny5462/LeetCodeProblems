/**
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

Input:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

Output:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |

 Done using sparse matrix multiplication by storing in array of lists, all the cols of every row along with their values as sequence (col,val(row,col) in the lists, that are non zero. We ,then traverse the array of lists and multiply the elements one by one with the other matrix and fill the answer matrix.
TC-O(m*p) where m is row of matA and p is col of mat b
credits -https://leetcode.com/problems/sparse-matrix-multiplication/discuss/76154/Easiest-JAVA-solution 
**/


class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m=A.length;
        int n=A[0].length;
        int nb=B[0].length;
        int[][] ans=new int[m][nb];
        
        List[] indexA=new List[m];
        for(int i=0;i<m;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<n;j++){
                if(A[i][j]!=0){
                    list.add(j);
                    list.add(A[i][j]);
                }
            }
            indexA[i]=list;
        }
        
        for(int i=0;i<m;i++){
            List<Integer> list=indexA[i];
            for(int p=0;p<list.size()-1;p+=2){
                int colA=list.get(p);
                int valA=list.get(p+1);
                for(int j=0;j<nb;j++){
                    int valB=B[colA][j];
                    ans[i][j]+=valA*valB;
                }
            }
        }
        return ans;
    }
}
