/** program to find whether any path from root to leaf results in a given path length.DOne Using recursion, where every node, that is traversed , its value is deducted from given sum, so at the end, the leaf node and remaining sum have to be equal to satisfy the condition
TC-O(H).
credits to-https://leetcode.com/problems/path-sum/discuss/331959/Java-three-line-100-100-solution
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

    public boolean hasPathSum(TreeNode root, int sum) {
      if(root==null)return false;
      if(root.val==sum&&root.left==null&&root.right==null){return true;}
      return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}
