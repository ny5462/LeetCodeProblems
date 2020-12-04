/** program to construct binary tree from inorder and preorder traversals , done using recursion by finding recursively index of root in inorder, as elements before that index are to left of it in the tree, and vice versa. so we keep iterating preorder and find index of corresponding values in inorder and allocate them to left and right respectively. 
credits- https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
TC-O(N^2)
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
    int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,inorder.length-1);
        
    }
        
        public TreeNode build(int []preorder, int[]inorder, int start, int end){
           if(start>end)return null;
            TreeNode root=new TreeNode(preorder[preindex++]);
            
            if(start==end)return root;
            
            int index=0;
            for(int i=start;i<=end;i++){
                if(inorder[i]==root.val){
                    index=i;
                    break;
                }
            }
            root.left=build(preorder,inorder,start,index-1);
            root.right=build(preorder,inorder,index+1,end);
            return root;
        }
    
}
