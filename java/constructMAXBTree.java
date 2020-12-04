/** Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.
Credits-https://leetcode.com/problems/maximum-binary-tree/solution/
TC-O(N^2) in case of sorted array
**/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxBTree(nums,0,nums.length);
    }
    public TreeNode maxBTree(int [] nums,int l, int r){
        if(l==r)return null;
        int max_i=max(nums,l,r);
        TreeNode root= new TreeNode(nums[max_i]);
        root.left=maxBTree(nums,l,max_i);
        root.right=maxBTree(nums,max_i+1,r);
        return root;
    }
    
    public int max(int[]nums, int l, int r){
        int max=l;
        for(int i=l;i<r;i++){
            if(nums[i]>nums[max])max=i;
        }
        return max;
    }
    
}
