/** program to check whether given BST is valid or not, done using recursion by keeping upper and lower limits for each subtree.
credits-https://leetcode.com/problems/validate-binary-search-tree/discuss/32109/My-simple-Java-solution-in-3-lines**/
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
    public boolean isValidBST(TreeNode root){
        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long min, long max) {
        if(root==null)return true;
        if(root.val<=min||root.val>=max)return false;
        
        return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);
    }
}
