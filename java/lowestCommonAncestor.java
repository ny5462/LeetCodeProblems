/**Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1

 Done by maintaining parent nodes in a map of every node, we traverse the tree using a stack and fill up the parent node map,
 after the map is made, we create a set of ancestors of all the nodes of p and store it in a set. After that we traverse up from the q node,
 till the set contains an ancestor of q. In this way, we find the lowest common ancestor of both p and q.
 TC-O(N)
 credits- https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        parent.put(root,null);
        while(!parent.containsKey(p)||!parent.containsKey(q)){
            TreeNode node=stack.pop();
            if(node.left!=null){
                stack.push(node.left);
                parent.put(node.left,node);
            }
            if(node.right!=null){
                stack.push(node.right);
                parent.put(node.right,node);
            }
        }
        Set<TreeNode> ancestors=new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p=parent.get(p);
        }
        while(!ancestors.contains(q)){
            q=parent.get(q);
        }
        return q;
    }
}

 
