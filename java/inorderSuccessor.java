/**
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

The successor of a node p is the node with the smallest key greater than p.val.
Done by storing nodes in a list of TreeNodes, then traversing it to check if a node is found.
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
    List<TreeNode> ans=new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null)throw null;
        inorder(root);
        for(int i=0;i<ans.size();i++){
            TreeNode node=ans.get(i);
            if(node.val>p.val)return node;
        }
        return null;
        
    }
    public void inorder(TreeNode root){
        if(root==null)return;
        if(root.left!=null)inorder(root.left);
        ans.add(root);
        if(root.right!=null)inorder(root.right);
    }
}

/**
faster recursive solution
credits-https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/791/discuss/601299/Java-short-and-easy-100
TC-O(h)
**/

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return find(null, root, p);
    }
    
    public TreeNode find(TreeNode parent, TreeNode root, TreeNode p){
        if (root == null) return parent;
        
        if (p.val < root.val) return find(root, root.left, p);
        
        return find(parent, root.right, p);
    }
}
