/** build binary tree from given postorder and inorder traversals, done using hashmaps, and iterating on postorder from behind as they are the root elements, find index of root recursively in inorder, and elements to left of index are left subtree of root, and elements to right are in right subtree of root. Doing that recursively and building the tree.
O(N)
Credits- https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/
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
    int postorder[];
    int inorder [];
    int post_idx;
    HashMap<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder=inorder;
        this.postorder=postorder;
        post_idx=postorder.length-1;
        //saving inorder indices in a map
           for(int i=0;i<inorder.length;i++){
               map.put(inorder[i],i);
           }  
          return helper(0,inorder.length-1);
        
    }
    
    public TreeNode helper(int left_ind, int right_ind){
        if(left_ind > right_ind)return null;       
        int root_val=postorder[post_idx];
        //going to next index as previous is processed
        post_idx--;
        //getting index of root val in inorder array
        int inorder_root_index=map.get(root_val);
        // create a node from the value of root
        TreeNode root=new TreeNode(root_val);
        //everything to right of root in inorder array actually is in its right subtree, so we recurse
        root.right=helper(inorder_root_index+1,right_ind);
        //elements to left of root node in inorder are in its left subtree, so we recurse around it
        root.left=helper(left_ind,inorder_root_index-1);
        return root;
    }
}

