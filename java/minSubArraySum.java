/** minimum length subarray of sum greater than or equal to a given value
done using 2pointers, we iterate from a right pointer till we exceed or equal a given sum, after that we compress from left pointer till the condition holds, once it fails, we again move the right pointer.
TC-O(N)
**/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i=0,j=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while(j<nums.length && i<nums.length){
            if(nums[j]>=s && j-i==0)return 1;
            while(sum<s &&j<nums.length){
                sum+=nums[j++];
            }
            while(sum>=s &&i<nums.length){              
                sum-=nums[i++];
                min=Math.min(min,j-i+1);
        
                
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}

//better looking code
class Solution {
   public int minSubArrayLen(int s, int[] nums)
{
    int n = nums.length;
    int ans = Integer.MAX_VALUE;
    int left = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += nums[i];
        while (sum >= s) {
            ans = Math.min(ans, i + 1 - left);
            sum -= nums[left++];
        }
    }
    return (ans != Integer.MAX_VALUE) ? ans : 0;
}
}
