/** program to find Kth largest element in array
TC-O(NlogN)
**/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int Ktemp=nums[nums.length-1];
        int count=0;
        for(int i=nums.length-1;i>=0;i--){
            count++;   
            if(k==count){
                return nums[i];
            }
        }
        throw null;
    }
}
