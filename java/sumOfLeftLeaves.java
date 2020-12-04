/** program to find sum of all left side leaf nodes in binary tree. DOne using recursion by checking if the node is a left side leaf node, if not, the right side is checked for a left side leaf node.
credits to geeky shubham-https://leetcode.com/problems/sum-of-left-leaves/discuss/333213/java-Recursive-solution-0-ms
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

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0;
        else if(root.left!=null&&root.left.left==null&&root.left.right==null){
            return root.left.val+sumOfLeftLeaves(root.right);
        }
        else{
            return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        }
    }
}
