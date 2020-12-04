/** level order of binary treee in bottom up . done using bfs using queue and storing in stack and then popping it to return reverse order.
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stack=new Stack<>();
        Queue<TreeNode> q=new LinkedList();
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null)return ans;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                l.add(node.val);
                
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            stack.add(l);
        }
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
}
