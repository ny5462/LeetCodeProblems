/**Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 

Example:

Input: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

Output: [[4,5,3],[2],[1]]

 

Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         / 
        2          

 

2. Now removing the leaf [2] would result in this tree:

          1          

 

3. Now removing the leaf [1] would result in the empty tree:
Done using topological sort and storing leaves of every iteration by treating tree as a graph
TC-O(N)
**/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Queue<TreeNode> q= new LinkedList<>();
    HashMap<TreeNode,List<TreeNode>> map= new HashMap<>();
    HashMap<TreeNode,Integer> count=new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
    	// storing indegree and outdegree for topo sort
        inorder(root);
        
        // adding in queues all nodes with indegrees 0 that is leaf nodes
        for(TreeNode node:count.keySet()){
            if(count.get(node)==0){
                q.add(node);
            }
        }
              
        List<List<Integer>> ans =new ArrayList<>();
        while(!q.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(TreeNode node:q){
                temp.add(node.val);
            }
            ans.add(temp);
            int size=q.size();
            // iterating all elements of queue and deleting their connection from graph
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                List<TreeNode> neighs=map.get(node);
                for(TreeNode n:neighs){
                    count.put(n, count.get(n)-1);
                    // after removing connection all nodes with indegree 0 are added to q
                    if(count.get(n)==0){
                        q.add(n);
                    }
                }
            }
            
        }
        
        return ans;
        
    }
    
    public void inorder(TreeNode root){
        if(root==null)return;
        if(!map.containsKey(root)){
            map.put(root,new ArrayList<>());            
        }
        if(!count.containsKey(root)){
            count.put(root,0);
        }
        if(root.left!=null){
            if(!map.containsKey(root.left)){
                map.put(root.left,new ArrayList<>());
                   
            }          
            map.get(root.left).add(root);
            count.put(root,count.getOrDefault(root,0)+1);
        }
        if(root.right!=null){
            if(!map.containsKey(root.right)){
                map.put(root.right,new ArrayList<>());
            }
            map.get(root.right).add(root);
            count.put(root,count.get(root)+1);
        }
        inorder(root.left);
        inorder(root.right);
        
    }
}
