/** program to find a number in an array of duplicates that is not repeated.
TC-O(N). Done using bit manipulation, using XOR operation as a^0=a,a^a=0.
Credits-https://leetcode.com/problems/single-number/solution/.
**/
class Solution {
    public int singleNumber(int[] nums) {
       int x=0;
        for(int i:nums){
            x^=i;
        }
        return x;
    }
}
