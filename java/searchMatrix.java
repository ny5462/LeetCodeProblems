/** a matrix where rows are sorted and columns are sorted, we need to search for an element. one using binary search kind of approach where if target is greater than last element in first row, we increment row, if target is smaller than current element, we reduce the column no.
O(m+n)
credits- https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/433219/Java-Sol-or-100-faster-or-100-better-memory-usage
**/




class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        if(row==0)return false;
        int col=matrix[0].length;
        int i=0;
        int j=col-1;
        while(i<row && j>=0){
            if(target==matrix[i][j])return true;
            else if(target > matrix[i][j])i++;
            else j--;
        }
        return false;
    }   
}
