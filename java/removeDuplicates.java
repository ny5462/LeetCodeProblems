/**
This program removes returns the length of unique integers in an array
by shifting them towards the lhs of the array , the array is already sorted.
The approach used is to maintain a counter , and look for the next element 
that is not the original one, and put it in the place next to the original element
TC- O(n)
**/
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return 1;
        int temp=nums[0];
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=temp){
                count++;
                nums[count]=nums[i];
                temp=nums[count];
            }
        }
        return count+1;    
    }
}

/** second attempt**/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0||nums.length==1)return nums.length;
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                nums[++i]=nums[j++];
            }
        }
        return i+1;
    }
}
