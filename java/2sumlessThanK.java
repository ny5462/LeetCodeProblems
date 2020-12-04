/** program to find sum of 2 numbers less than K, and maximize their sum. if no such pair exists, return -1.
Done using 2 pointers on a sorted list.
TC-O(nlogn)
**/
class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if(A.length==1)return -1;
        Arrays.sort(A);
        int max=0;
        int l=0, r=A.length-1;
        while(l<r){
            if(A[l]+A[r]>=K){
                r--;
            }
            else if(A[l]+A[r]<K){
                int temp=A[l]+A[r];
                max=Math.max(max,temp);
                l++;
            }
        }
        return max==0?-1:max;
    }
}
