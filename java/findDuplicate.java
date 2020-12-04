/**Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one duplicate number in nums, return this duplicate number.

Follow-ups:

    How can we prove that at least one duplicate number must exist in nums? 
    Can you solve the problem without modifying the array nums?
    Can you solve the problem using only constant, O(1) extra space?
    Can you solve the problem with runtime complexity less than O(n2)?
**/
// by sorting the array and iteration TC-O(nlogn)
class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length<2)return 1;
        Arrays.sort(nums);
        int prev=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==prev)return nums[i];
            else{
                prev=nums[i];
            }
        }
        return -1;
    }
}

// without shifting array elements TC-O(N)
class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length<2)return 1;
        int[] freq=new int[nums.length-1];
        int val=-1;
        for(int i=0;i<nums.length;i++){
            val=nums[i];
            if(freq[val-1]==1){
                break;
            }
            freq[val-1]=1;
        }
        return val;
}
}
