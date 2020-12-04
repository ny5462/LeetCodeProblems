/** program to find index of given element in a sorted array, if not
found , return the ideal position of it in the array
 TC-O(n)**/
class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i=0; i<nums.length;i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }
}
