/** program to convert a sorted array to height balanced BST. Done using recursion , by taking the median of the array as root, and iterating its left part  recursively for the left side, and its right part recursively for the right side.
Credits to -https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/337100/Java-simple-recursive-solution-100-faster-and-99.87-less-space
for the excellent solution.
TC-O(N)
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0||nums==null)return null;   
        return sortedArrayToBST(nums,0,nums.length-1);       
    }
    private TreeNode sortedArrayToBST(int[]nums, int l,int r){
        if(l>r)return null;
        int m=(l+r)/2;
        TreeNode root=new TreeNode(nums[m]);
        root.left=sortedArrayToBST(nums,l,m-1);
        root.right=sortedArrayToBST(nums,m+1,r);
        return root;
    
    }
}
