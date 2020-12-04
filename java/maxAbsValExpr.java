/** program to find max value of expression Given two arrays of integers with equal lengths, return the maximum value of:

|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|

where the maximum is taken over all 0 <= i, j < arr1.length.
TC-O(N^2)
**/
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        if(arr1.length==0||arr2.length==0)return 0;
        int max1=Integer.MIN_VALUE/2;
        for(int i=0;i<arr1.length-1;i++){
            for(int j=i+1;j<arr1.length;j++){
                 int num=Math.abs(arr1[i]-arr1[j])+Math.abs(arr2[i]-arr2[j])+Math.abs(i-j);
                 if(max1<num)max1=num;
            }
    }return max1;
}
}
