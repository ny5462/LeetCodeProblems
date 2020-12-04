/**
Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.

Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

done by converting tree to graph, then performing bfs, as soon as first leaf node is encountered, we end the loop.
credits- https://leetcode.com/problems/closest-leaf-in-a-binary-tree/discuss/112817/Very-Easy-Understanding-JAVA-Build-Graph%2BBFS

TC- Build graph(O(N)), BFS(O(N))
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
    public int findClosestLeaf(TreeNode root, int k) {
        if(root.left==null &&root.right==null)return root.val;
        // create graph adjacency list of undirected graph
        Map<TreeNode, List<TreeNode>> graph=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        TreeNode start=null;
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            // performing bfs and creating graph storing adjacency list in map
            
            if(!graph.containsKey(node)){
                graph.put(node,new ArrayList<TreeNode>());
            }
            
            if(node.left!=null){
                graph.get(node).add(node.left);
                graph.putIfAbsent(node.left, new ArrayList<>());
                graph.get(node.left).add(node);
                q.add(node.left);
            }
            
            if(node.right!=null){
                graph.get(node).add(node.right);
                graph.putIfAbsent(node.right, new ArrayList<>());
                graph.get(node.right).add(node);
                q.add(node.right);
            }
            //start node of graph when found, we store it
            if(node.val==k){
                start=node;
            }
        }
        q.clear();
        Set<TreeNode> seen= new HashSet<>();
        seen.add(start);
        q.offer(start);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            List<TreeNode> edges= graph.get(node);
            if(edges.size()==1 && node!=root){
                return node.val;
            }
            
            for(TreeNode e: edges){
                if(seen.contains(e))
                    continue;
                else if(graph.get(e).size()==1 && e !=root){
                    return e.val;
                }
                q.offer(e);
                seen.add(e);
            }
        }
        return root.val;  
    }
}



