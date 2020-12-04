/**program to find an element which occurs more than n/2 times in the array. Done by sorting
the array and accessing the element at the middle
TC-O(NlogN)
**/
class Solution {
    public int majorityElement(int[] nums) {
       Arrays.sort(nums);
       return nums[nums.length/2];
    }
}
