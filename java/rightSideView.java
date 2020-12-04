/** program to return right side view of binary tree, done using bfs, and return extreme right node at every level. Done using linkedlist as a queue
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> r=new ArrayList<>();
        if(root==null)return r;
        LinkedList<TreeNode> q=new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            r.add(q.get(size-1).val);
            for(int i=0;i<size;i++){
                TreeNode node =q.remove(0);
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            
        }
        return r;
    }
}
