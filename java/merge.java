/**Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Easy peezy
TC- O(N)
**/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[]arr=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m&&j<n){
            if(nums1[i]>nums2[j]){
                arr[k++]=nums2[j++];
            }else{
                arr[k++]=nums1[i++];
            }
        }
        while(i<m){
            arr[k++]=nums1[i++];
        }while(j<n){
            arr[k++]=nums2[j++];
        }
        int index=0;
        for(int num:arr){
            nums1[index++]=num;
        }
    }
}
