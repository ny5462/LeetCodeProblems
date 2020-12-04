/** program to find minimum difference in values between any 2 nodes in a BST. Done using inorder traversal and storing the nodes in a list, which sorts them in order of their values.
Next, traverse the list once, to look for minimum difference.
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
    public int minDiffInBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        inorder(root,list);
        int temp = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            if (val - temp < min) min = val - temp;
            
            temp = val;
        }
        return min;
        
    }
    public void inorder(TreeNode root, List<Integer> nodes){
        if(root==null)return;
        inorder(root.left,nodes);
        nodes.add(root.val);
        inorder(root.right,nodes);
    }
}
