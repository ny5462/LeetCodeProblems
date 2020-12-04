/** program to find second min element in BST. done using inorder traversal and storing the traversed elements in a treeSet. Then restoring the second element from the treeset.
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
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set=new TreeSet<>();
        inorder(root,set);
        if(set.size()<2)return -1;
        int temp=set.first();
        for(int v:set){
            if(v!=temp)return v;
        }
        return -1;
        
    }
    public void inorder(TreeNode root, TreeSet<Integer> set){
        if(root==null)return;
        inorder(root.left,set);
        set.add(root.val);
        inorder(root.right,set);
    }
}
