/**
You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
Example 1:

Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Done by maintaining three nodes, firstElement keeps track of the first occurence of misplacing, so it stores the first bigger element which is wrongly placed. Second element keeps track of the smaller element that is misplaced and should be in higher index of inorder traversal.
prev keeps track of prev node seen in inorder traversal. Since, there are exactly 2 wrongly placed elements, we keeping track of first and second element and swapping them, we restore the order.
second element keeps on changing, after first swap, first element is assigned to bigger no, second element is assigned to smaller number that was next to it. However, it is the last swap where we get the actual second element. first element remains constant after first assignment.
TC-O(N)
SC-O(1)
credits- https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
great explanation
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
    TreeNode firstElement=null;
    TreeNode secondElement=null;
    TreeNode pre=null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        //swappping the found nodes
        int temp=secondElement.val;
        secondElement.val=firstElement.val;
        firstElement.val=temp;
    }
    
    public void inorder(TreeNode root){
       if(root==null)return;
        inorder(root.left);
        // first index is null, so firstelement doesn't change, but first misplacement, this condition gets activated.
        if(firstElement == null && (pre==null|| pre.val>root.val)){
            firstElement=pre;
        }
        // after first activation of above condition, second is set, to the smaller element
        if(firstElement!=null && pre.val>root.val){
            secondElement=root;
        }
        // keep track of previous for next iteration of recursion to compare with that root
        pre=root;
        inorder(root.right);
    }
}

