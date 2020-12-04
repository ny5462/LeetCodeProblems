/** program to return product of array excluding the element at the current index, done using creation of two extra arrays , one stores the product of all elements before it, other stores product of all elements after it, we then multiply them.
 TC-O(N)
credits- https://leetcode.com/problems/product-of-array-except-self/solution/
**/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] L=new int[nums.length];
        int [] R=new int[nums.length];
        int[] ans=new int [nums.length];
        
        L[0]=1;
        for(int i=1;i<nums.length;i++){
            L[i]=L[i-1]*nums[i-1];
            
        }
        R[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            R[i]=R[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            ans[i]=L[i]*R[i];
        }
        return ans;
    }
}
