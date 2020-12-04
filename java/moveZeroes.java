/** program to move all the zeroes in an array to the back of the array in place. Done by using a counter of nonzero elements, and putting them in that index ,whenever nonzero is encountered. Later on iterating from counter of Nonzero to end of array and adding zeroes.
TC-O(N)
**/
class Solution {
    public void moveZeroes(int[] nums) {
        int nonzeroC=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]!=0){
               nums[nonzeroC]=nums[i];
               nonzeroC++;
         }
}
        for(int i=nonzeroC;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
