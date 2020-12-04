/** program for Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
TC-O(n^2)
**/
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=i+k&&j<nums.length;j++){
                if(Math.abs((long)nums[i]-nums[j])<=t){
                    return true;
                }
            }
        }
        return false;
    }
}

/** done using treeset of k elements at a time, where the elements are sorted generally in treestructure, using floor and ceiling we find the minimum element smaller or larger than current element and satisfies the condition.
Credits- https://leetcode.com/problems/contains-duplicate-iii/solution/
TC-O(nlogk)
**/
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Integer s=set.ceiling(nums[i]);
            if(s!=null && s<=t+nums[i])return true;
            
            Integer g=set.floor(nums[i]);
            if(g!=null && nums[i]<=t+g)return true;
            
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
