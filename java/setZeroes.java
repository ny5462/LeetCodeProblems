/** program to fill rows and columns of elements which contain a zero with zero, try to do it in constant space or O(mn) time. First approach done using 2 sets which keep track of row and column of grid with zero in it. then extracting elements from those sets to change row and column to zero.
TC-O(3*mn)
**/
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows=new HashSet<>();
        Set<Integer>cols=new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i:rows){
            for(int m=0;m<matrix[0].length;m++){
                matrix[i][m]=0;
            }
        }
        for(int j:cols){
            for(int m=0;m<matrix.length;m++){
                matrix[m][j]=0;
            }
        }
    }
}
