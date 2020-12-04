/**
Program to find the longest arithmetic subsequence. Done using Dynamic programming 2d approach.
TC- O(n^3)
**/
class Solution {
    public int longestArithSeqLength(int[] A) {
        int S[][]=new int[A.length][A.length];
        int max=1;
        for(int i=A.length-2;i>=0;i--){
            for(int j=i+1;j<A.length;j++){
                int gap=A[i]-A[j];
                S[i][j]=1;
                for(int k=j+1;k<A.length;k++){
                    if(A[j]-A[k]==gap){
                        S[i][j]=Math.max(S[i][j],1+S[j][k]);
                        max=Math.max(max,S[i][j]);
                        break;
                    
                    }
                }
            }
        }
        return 1+max;
    }
}
