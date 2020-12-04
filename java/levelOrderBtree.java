/** level order traversal of binary tree done using queue and BFS. TC-O(N)**/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
       
        if(root==null)return ans;
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
     
        while(!q.isEmpty()){
            List<Integer> l =new ArrayList<>();
            int size=q.size();
           
            for(int i=0;i<size;i++){
                 TreeNode node=q.poll();
                   if(node.left!=null){
                     q.add(node.left);
                    }if(node.right!=null){
                     q.add(node.right);
                          }
                    l.add(node.val);
            }
            ans.add(l);   
        }
        return ans;
    }
}

