/** program to rotate a matrix clockwise.DOne by first reversing the rows, then transposing the matrix.
TC-O(N)
**/
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0)return;
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0,j=row-1;j>i;i++,j--){
            int[] temp=new int[col];
            temp=matrix[i];
            matrix[i]=matrix[j];
            matrix[j]=temp;
        }
        for(int i=0;i<row;i++){
            for(int j=i+1;j<col;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
    }
}
