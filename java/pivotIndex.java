/** program to find pivot index, where sum of elements on right of pivot are equal to sum of elements on left of pivot. Done using maintaing variables that store total sum, left and right sum, and present element. Done by iterating through array and reducing from right, and adding on left, till condition satisfied.
TC-O(N)
**/
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length==0||nums.length==2)return -1;
        if(nums.length==1)return 0;
        int left=0;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        int right=sum;
        int present=0;
        for(int i=0;i<nums.length;i++){
            present=nums[i];
            right=sum-present-left;
            if(left==right)return i;
            left=left+present;
        }
        return -1;
    }
}
