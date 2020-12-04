/** zigzagorder traversal in btree, done using BFS of linkedList as a queue, and modifying bfs, using a boolean variable zig to decide when to zig and when to zag, and iterating the LL from last,
O(N)
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null)return ans;
         LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean zig=false;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=size-1;i>=0;i--){
                TreeNode node=q.remove(i);
                l.add(node.val);
                if(zig){
                     if(node.right!=null)q.add(node.right);
                    if(node.left!=null)q.add(node.left);
                }
                if(!zig){
                     if(node.left!=null)q.add(node.left);
                    if(node.right!=null)q.add(node.right);
                }
               
            }
            zig=!zig;
            ans.add(l);
        }
        return ans;
    }
}
