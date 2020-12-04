/** maximum sum with no adjacent elements selected, DP approach
TC-O(N)
credits -https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
**/
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)return 0;
        int incl=nums[0];
        int excl=0;
        int excl_new;
        for(int i=1;i<nums.length;i++){
            excl_new=incl>excl?incl:excl;
            incl = excl+nums[i];
            excl=excl_new;
        }
        return incl>excl? incl:excl;
    }
}
