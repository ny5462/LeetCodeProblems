/** program to check whether 2 binary trees are the same. Done using recursion, by travelling every node, and if mismatch is found at any node, denying the equivalence.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p==null&&q!=null||q==null&&p!=null)return false;
        if(p.val!=q.val)return false;
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        
    
        
    }
}
