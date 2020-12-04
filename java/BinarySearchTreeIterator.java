/**Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.
Done by maintaining a list by doing inorder traversal, which adds element in sorted order.
Since the next() calls will always be valid, i stored the size of the tree for hasnext() and maintained a variable to look for the next big variable
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
class BSTIterator {
    List<Integer> list=new ArrayList<>();
    int index=0;
    int size=0;
    public BSTIterator(TreeNode root) {
        inorder(root);
        this.size=list.size();
        
    }
    
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }   
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index<size;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

