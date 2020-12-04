/**program to flip and invert image, where [1,1,0] becomes [0,1,1] ,then flipped
to form [1,0,0]. Done using nested for loops and swaps, then flipping it inplace ,
i.e if position has 0, make it 1 and vice-versa. Checked also for odd length strings ,
 outside the loop whose middle element is flipped .
TC-O(N^2)**/
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i++){
            for(int j=0,k=A[0].length-1;k>j;j++,k--){
                int temp=A[i][j];
                A[i][j]=A[i][k];
                A[i][k]=temp; 
                if(A[i][j]==0)A[i][j]=1;
                else A[i][j]=0;
                if(A[i][k]==0)A[i][k]=1;
                else A[i][k]=0;
            }
            if(A[i].length%2==1){
            if(A[i][A[i].length/2]==0)A[i][A[i].length/2]=1;
            else A[i][(A[i].length)/2]=0;
            }
        }
        return A;
    }
}

