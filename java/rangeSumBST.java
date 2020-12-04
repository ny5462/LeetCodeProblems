/** program to find total of all the nodes in a BST between value of L and R.Done recursively by travelling till the edge nodes and keep on adding values. (Edge nodes, being L&R)
TC-O(H). value should be greater than or equal to L and less than or equal to R.
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
    
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null)return 0;
        else if(root.val>=L&&root.val<=R){
            return root.val+rangeSumBST(root.left,L,R)+rangeSumBST(root.right,L,R);
        }
        else{
            return rangeSumBST(root.left,L,R)+rangeSumBST(root.right,L,R);
        }
    }
}
                
            
        
