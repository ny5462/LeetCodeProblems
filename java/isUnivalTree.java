/** program to find whether all the nodes in tree have the same value.
DOne using recursive calls, and checking whether the node is either null or the value at the branch matches the root value. 
credits to https://leetcode.com/problems/univalued-binary-tree/solution/
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
    public boolean isUnivalTree(TreeNode root) {
       boolean left_c=(root.left==null||root.left.val==root.val&&isUnivalTree(root.left));
        boolean right_c=(root.right==null||root.right.val==root.val&&isUnivalTree(root.right));
        return left_c&&right_c;
        
    }
}
