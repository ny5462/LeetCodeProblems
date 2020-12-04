/** program to sort the tree in such a way, that all the values are arranged, by making the leftmost node as the root of the tree. Inorder traversal traverses the tree in a sorted order, as values which are smaller than root,are to its left, and values which bigger to its right.
List which is sorted is stored, than new nodes are created and traversed according to increasing order. Credits to https://leetcode.com/problems/increasing-order-search-tree/solution/
TC-O(H)
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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        TreeNode head=new TreeNode(0);
        TreeNode temp=head;
        for(int v:list){
            head.right=new TreeNode(v);
            head=head.right;
            
        }
        return temp.right;
        
        
    }
    public void inorder(TreeNode root, List<Integer> nodes){
        if(root==null)return;
        inorder(root.left,nodes);
        nodes.add(root.val);
        inorder(root.right,nodes);
    }
}
