/** program to find sum of maximum subarray in an array.
Done using a simple approach of maintaining and updating two variables of sum and max.
TC-O(N)
credits-https://leetcode.com/problems/maximum-subarray/discuss/340901/Java-dp
**/
class Solution {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=sum+nums[i]>nums[i]?sum+nums[i]:nums[i];
            max=Math.max(sum,max);
                
        }
        return max;
        
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
	int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum=Math.max(sum,0)+nums[i];
            max=Math.max(sum,max);
                
        }
        return max;
        
    }
}
