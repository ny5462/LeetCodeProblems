/**
program is used to search an element in an array which is sorted in ascending order but twisted arounded a pivot element. Done using binary search twice, first finding the pivot element using binary search. Then realigning the start and end index using the pivot position, and finding the target using binary search.
TC-O(logN)
credits- https://leetcode.com/karnyong/
**/

class Solution {
    
    public int search(int[] nums, int target) {
        if(nums.length==0)return -1;
        int minInd=findMinIndex(nums);
        if(target==nums[minInd])return minInd;
        int n=nums.length-1;
        int start=target<=nums[n]?minInd:0;
        int end=target>nums[n]?minInd:n;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>target){
                end=mid-1;
            }else if(nums[mid]<target){
                start=mid+1;
            }else if(nums[mid]==target){
                return mid;
            }
        }
        return -1;
        
    }
    
    
    public int findMinIndex(int[] nums){
        int start=0;
        int end=nums.length-1;     
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[end]){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }
}
