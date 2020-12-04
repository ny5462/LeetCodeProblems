/** program to remove an element of a particular value inplace
in an array and return the length of the arrray after removal of 
the val from the array
TC -O(n)
**/
class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[count]=nums[i];
                count++;
        }}
        return count;
        
    }}

