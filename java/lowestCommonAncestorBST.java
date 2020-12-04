/** return lowest common ancestor in BST, because of properties of bst, if root val > both, it lies on left side, so recurse on left side, if root val< both, then recurse on right side, else return root , when found the split value.
TC-O(logN)
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parent=root.val;
        int pval=p.val;
        int qval=q.val;
        if(parent>pval&&parent>qval){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(parent<pval&&parent<qval){
            return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return root;
        }
    }
}
