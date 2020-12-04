/** Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.

As a reminder, a binary search tree is a tree that satisfies these constraints:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
Done using inorder traversal, storing the tree in a stack, then accesing elements by popping stack, and updating the values by summing the values of elements popped so far.
TC- O(n)
credits- https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/discuss/439302/Java-straight-forward-solution-using-stack-beat-100
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
    Stack<TreeNode> stack=new Stack<>();
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)return root;
        int sum=0;
        inorder(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            node.val+=sum;
            sum=node.val;
        }
        return root;
    }
    
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        stack.push(root);
        inorder(root.right);
    }
}
