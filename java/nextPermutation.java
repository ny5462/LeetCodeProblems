/** given a number array , return the next larger permutation, if no is in descending order return the smallest number possible.
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

Example 4:

Input: nums = [1]
Output: [1]
Done by using an algorithm mentioned in https://leetcode.com/problems/next-permutation/solution/ where we iterate from the last indices, till we find the number which is not sorted in ascending order on reverse traversal. we swap that number with the number which has the smallest difference from that number on the right side of its array and is larger than the number. Since, the part of array right to the found number is sorted in descending order, the first number we find which is larger than the found element, we swap it and then reverse the grid to the right after swapping, this sorts the right side of the array in ascending order and yields the number.
TC-O(N)
**/
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<2||nums==null)return;
        int index=-1;
        for(int i=nums.length-1,j=nums.length-2;i>=1&&j>=0;){
            if(nums[i]<=nums[j]){
                i--;
                j--;
            }
            else{
                index=j;
                break;
            } 
            
        }
        
        if(index==-1){
            reverse(nums,0,nums.length-1);
        }else{
            int ind=nextLarger(nums,index);
            swap(nums,ind,index);
            reverse(nums,index+1,nums.length-1);
        }     
    }
    
    public void swap(int[]nums, int ind,int index){
        int temp=nums[ind];
        nums[ind]=nums[index];
        nums[index]=temp;
    }
    
    public void reverse(int [] nums, int start, int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    
    public int nextLarger(int [] nums,int index){
        int j=nums.length-1;
        while(j>=index){
            if(nums[j]>nums[index]){
                return j;
            }else{
                j--;
            }
        }
        return j;
    }
    
}
