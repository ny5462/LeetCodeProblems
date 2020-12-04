/** program to check if the tree is balanced at all levels and subtrees, i.e difference of height between any subtree shouldn't exceed 1.
Done recursively using a helper function , which return the maximum height between the left and right subtree.
The function recursively uses the helper function to evaluate the difference between left and right subtrees, to check if it exceeds 1.
TC-O(N)
credits to -https://leetcode.com/problems/balanced-binary-tree/discuss/332901/Java-Recurrence-Solution-Very-Easy-to-Understand
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
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        if(Math.abs(height(root.left)-height(root.right))>1)return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
}
