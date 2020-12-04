/** kth smallest element in BST, inorder traversal leads to traversal in sorted manner, as soon as list size reaches k, return the k-1th index element.
TC-O(K)
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
    int k;
    List<Integer> list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
         this.k=k;
        inorder(root);
        return list.get(k-1);
    }
    
    public void inorder(TreeNode root){
        if(root!=null){
            if(root.left!=null){
                inorder(root.left);
            }
            list.add(root.val);
            if(list.size()==k)return;
            if(root.right!=null){
                inorder(root.right);
            }
        }
    }
}

/** better way**/
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
    List<Integer> ans=new ArrayList();
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)throw null;
        inorder(root,k);  
        return ans.get(k-1);
        
    }
    public void inorder(TreeNode root){
        if(root==null)return ans;
        if(root.left!=null)inorder(root.left);
        ans.add(root.val);
        if(root.right!=nll)inorder(root.right);
    }
}

/** fastest way inplace 
credits- https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/790/discuss/624172/Java-Inorder-traversal-with-tree-pruning-0-ms
TC-O(K)
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
    int element;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)throw null;
        element=Integer.MIN_VALUE;
        inorder(root,k);
        return element;
        
    }
    public void inorder(TreeNode root, int k){
        if(root!=null &&count<k){
            inorder(root.left,k);
            if(count<k){
                count++;
                element=root.val;
            }
            if(count==k)return;
            else inorder(root.right,k);
        }
        
        
    }
    
}
