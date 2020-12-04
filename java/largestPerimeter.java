/** program to find the largest permieter of triangle formed by any three sides of given array.
Done by first sorting the array. The biggest three numbers are checked to satisfy the triangle condition that sum of smaller 2 nos exceeds the largest number.
TC-O(NlogN)
**/
class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int len=A.length;
        for(int i=len-1,j=len-2,k=len-3;i>=2&&j>=1&&k>=0;i--,k--,j--){
           int side1=A[i];
           int side2=A[j];
           int side3=A[k];
           if(side2+side3>side1)return side1+side2+side3; 
        }
        
        return 0;
    }
}
