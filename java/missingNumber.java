/** program to find missing number in a given array, of numbers from 0..n
TC-O(N)
**/
class Solution {
    public int missingNumber(int[] nums) {
      int expect=(nums.length*(nums.length+1))/2;
    int actual=0;
        for(int i:nums)actual+=i;
        return expect-actual;
}
}
