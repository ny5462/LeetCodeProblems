/** program to find kth missing element in a sorted array, done by linear search, by reducing k according to conditions.
TC-O(N)
**/
class Solution {
    public int missingElement(int[] nums, int k) {
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            if((nums[i+1]-nums[i])>k){
                ans= nums[i]+k;
                k=0;
                break;
            }
            else if(nums[i+1]-nums[i]==1){
                continue;
            }
            else{
                if(k-(nums[i+1]-nums[i]-1)<=0){
                    ans= nums[i]+k;
                    break;
                }
                k-=(nums[i+1]-nums[i]-1);
            }
        }
        return k>0?nums[nums.length-1]+k: ans;
    }
}

/** binary search -O(logN)
credits- https://leetcode.com/problems/missing-element-in-sorted-array/discuss/442944/Java-O(log-N)-binary-search
**/


class Solution {
    public int missingElement(int[] nums, int k) {
        
        int lo = 0;
        int hi = nums.length - 1;
        int missing = 0;
        
        while (hi - lo > 1) {
            int mid = (lo + hi) / 2;
            missing = nums[mid] - nums[lo] - (mid - lo);
            if (k > missing) {
                // Go right
                k -= missing;
                lo = mid;
            }
            else {
                hi = mid;
            }
        }
        
        if (k > nums[hi] - nums[lo]) {
            // we need to go outside
            return nums[hi] + k - (nums[hi] - nums[lo] - (hi - lo));
        }
        
        return nums[lo] + k;
    }
}
