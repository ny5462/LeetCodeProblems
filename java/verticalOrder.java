/** program to traverse a btree in vertical order, done using 2 queues and a hashmap , second queue for maintaining the col no, hashmap to keep a count of the elements in a column.
credits- beautiful solution by https://leetcode.com/problems/binary-tree-vertical-order-traversal/discuss/76401/5ms-Java-Clean-Solution
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList();
        Queue<Integer> cols=new LinkedList();
        Map<Integer, ArrayList<Integer>> map=new HashMap<>();
        
        q.add(root);
        cols.add(0);
        int min=0,max=0;
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            int col=cols.poll();
            
            if(!map.containsKey(col))map.put(col,new ArrayList());
            map.get(col).add(node.val);
            
            if(node.left!=null){
                q.add(node.left);
                cols.add(col-1);
                min=Math.min(min,col-1);
            }
            
            if(node.right!=null){
                q.add(node.right);
                cols.add(col+1);
                max=Math.max(max,col+1);
            }
                      
        }
        for(int i=min;i<=max;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}

