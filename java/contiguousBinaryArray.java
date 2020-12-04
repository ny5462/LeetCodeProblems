/** program to find maximum contigous subarray of 0's and 1's where no of zero is equal to no of one. DOne using hashmap.
TC-O(N)
credits- https://leetcode.com/problems/contiguous-array/discuss/407180/JAVA-hashmap-%2B-prefix-sum-100-space
**/

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int ans = 0,sum=0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==0) nums[i] = -1;
            sum += nums[i];
            if(map.containsKey(sum)) ans = Math.max(ans,i-map.get(sum)+1);
            else map.put(sum,i+1);
        }
            return ans;
    }
    
}

