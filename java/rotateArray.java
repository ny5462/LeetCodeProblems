/** program to rotate an array or shift right by a given number.
Approach  done using extra array and 2 pass. TC-O(2N)
**/
class Solution {
    public void rotate(int[] nums, int k) {
         k=k%nums.length;
        int [] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[(i+k)%nums.length]=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
    }
}

