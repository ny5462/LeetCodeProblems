/**
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.

Done using maintaining an array list, doing inorder traversal, and keeping track of lowest difference while insertion in the array List
TC-O(N)
**/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> l=new ArrayList<>();
    double min;
    double target;
    int val;
    public int closestValue(TreeNode root, double target) {
        this.min=Math.abs((double)root.val-target);
        this.target=target;
        this.val=root.val;
        try{
            inorder(root);
        }catch (NullPointerException e){
            return val;
        }
        return val;
    }
    
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        l.add(root.val);
        //after adding in list it compares it with global min difference and if difference is smaller, it adjusts valuess
        double temp=Math.abs((double)root.val-target);
        if(temp<=min){
            min=temp;
            this.val=root.val;
        }     
        inorder(root.right);
    }
}
