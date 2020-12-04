/* program to find minimum absolute difference between any two nodes in BST.
Approach 1 is bad, brute force done using dfs, and storing values in list as traversed. Later
The list is traversed to check for minimum difference.
Approach 2 done using inorder traversal, and travelling the list just once.
TC-O(N*N-1)
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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            list.add(node.val);
            if(node.right!=null)stack.push(node.right);
            if(node.left!=null)stack.push(node.left);
            
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(min>Math.abs(list.get(i)-list.get(j)))min=Math.abs(list.get(i)-list.get(j));
            }
        }
        return min;
}
}


/** approach 2 using inorder traversal,
 credits to https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/317334/My-Java-2ms-Recursive-Solution-or-Easy-to-Understand**/
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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        this.inorder(root,list);
        for(int i=0;i<list.size()-1;i++){
            min=Math.abs(Math.min(min,list.get(i+1)-list.get(i)));
        }
        return min;
}
    public void inorder(TreeNode root,List<Integer> nodes){
        if(root==null)return;
        inorder(root.left,nodes);
        nodes.add(root.val);
        inorder(root.right,nodes);
    }
}
