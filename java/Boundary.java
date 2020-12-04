/** boundary values of binary tree anticlockwise. Done using  recursion of first left boundary nodes, then left leaves, then right leaves, then right boundary nodes.
TC-O(N)
credits- https://leetcode.com/problems/boundary-of-binary-tree/discuss/101280/Java(12ms)-left-boundary-left-leaves-right-leaves-right-boundary
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
    List<Integer> node=new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        if(root==null)return node;
        // first add root
        node.add(root.val);
        //add left boundary values
        leftBoundary(root.left);
        //add left subtree leaves anticlockwise
        leaves(root.left);
        // add right subtree leaves anticlockwise
        leaves(root.right);
        // add right boundary leaves
        rightBoundary(root.right);
        return node;
        
    }
    
    public void leftBoundary(TreeNode root){
        if(root==null||root.left==null&&root.right==null)return;
        node.add(root.val);
        if(root.left==null)leftBoundary(root.right);
        else leftBoundary(root.left);
    }
    
    public void rightBoundary(TreeNode root){
        if(root==null||root.left==null&&root.right==null)return;
        if(root.right==null)rightBoundary(root.left);
        else rightBoundary(root.right);
        node.add(root.val);
    }
    
    public void leaves(TreeNode root){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            node.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
    
}
