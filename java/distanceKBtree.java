/**
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.


Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.

Done using DFS and BFS, dfs to store the parent of each node in a hashmap, then performing bfs to check from target node, all nodes that are k levels apart, as it then becomes like a graph traversal problem.
TC-O(m+n)
credits- https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/236534/I-Made-A-Video-To-Explain-The-Breadth-First-Search**/

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
    Map<TreeNode,TreeNode> parent=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans=new ArrayList<>();
        Set<TreeNode> seen=new HashSet<>();		//keeps track of visited nodes
        dfs(root,null);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(target);
        seen.add(target);
        if(K==0){
            ans.add(target.val);
            return ans;
        }
        //performs bfs
        while(K-->=0){
            int size=queue.size();
            while(size-->0){
                TreeNode curr=queue.poll();
                if(curr!=null){
                    if(curr.right!=null &&!seen.contains(curr.right)){
                        queue.add(curr.right);
                        seen.add(curr.right);
                    }
                    if(curr.left!=null&&!seen.contains(curr.left)){
                        queue.add(curr.left);
                        seen.add(curr.left);
                    }
                    if(parent.get(curr)!=null&&!seen.contains(parent.get(curr))){
                        queue.add(parent.get(curr));
                        seen.add(parent.get(curr));
                    }
            }
        }	
        // stores level that is answer in a list
            if(K==0){
                for(TreeNode node:queue){
                    ans.add(node.val);
                
                }
                
            }
            
            
            }
        return ans;    
        
    }
    
    /** stores parent of each node in hashmap
    **/
    public void dfs(TreeNode node, TreeNode par){
        if(node!=null){
            parent.put(node,par);
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }
}
