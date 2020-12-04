/** program to find whether the sequences of leaves in 2 given trees are the same.
Done using dfs and storing the leaves, node, and traversing through the leaf nodes, till a mismatch occurs.
TC-O(N1+N2).. no of nodes in tree1 and tree2.
credits to -https://leetcode.com/problems/leaf-similar-trees/solution/
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1=new ArrayList<>();
        List<Integer> tree2= new ArrayList<>();
        dfs(root1,tree1);
        dfs(root2,tree2);
        if(tree1.size()!=tree2.size())return false;
        for(int i=0;i<tree1.size();i++){
            if(tree1.get(i)!=tree2.get(i))return false;
        }return true;
        
    }
    public void dfs(TreeNode node, List<Integer> leaves){
        if(node==null)return;
        if(node.left==null&&node.right==null){
                leaves.add(node.val);
        }
            else{
            dfs(node.left,leaves);
            dfs(node.right,leaves);
            }
        }
    }


