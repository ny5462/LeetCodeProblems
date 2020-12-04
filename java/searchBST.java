/** program to search for a value in BST , if not found return null. DOne Using recursion and traversing using rules of BST.
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val==val)return root; 
        else if(val>root.val){
            if(root.right==null)return null;
            return searchBST(root.right,val);
        }
        else {
            if(root.left==null)return null;
          return searchBST(root.left,val);
        }
        
        
    
    }
}
