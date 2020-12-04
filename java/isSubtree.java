/** Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself. 
Done using recursion, where we use kind of a preorder traversal in isSame method.
Credits- https://leetcode.com/problems/subtree-of-another-tree/discuss/433199/Java-Recursion-(Node-Comparison)-and-Preorder-Sequence-Comparison-(StringBuilder)
TC-O(m*n)
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null)    return t==null;

        return isSame(s,t )|| isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    public boolean isSame(TreeNode s, TreeNode t){
         if(s==null&&t==null) return true;
        
        if(s==null||t==null) return false;
        
        if(s.val!=t.val) return false;
        
        return isSame(s.left,t.left)&&isSame(s.right,t.right);
     }
}
