/** program to write tranpose of a matrix. Done by exchangig row and col values.
TC-O(N)
**/
class Solution {
    public int[][] transpose(int[][] A) {
        int cols=A[0].length;
        int row=A.length;
        int[][] trans=new int[cols][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                trans[j][i]=A[i][j];
            }
        }
        return trans;
    }
}
