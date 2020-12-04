/**
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.

 DOne using first storing the nodes in sorted using by doing inorder traversal. then traversing the node list and assigning circular pointers to the nodes, so next element is right, previous element is left, and head's left is last element and last element's right is head.
 TC-O(N)
 **/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    List<Node> sorted=new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        if(root==null)return root;
        inorder(root);
        for(Node n:sorted){
            System.out.print(n.val+" ");
        }
        return treeToCircular();
    }
    
    public void inorder(Node root){
        if(root==null)return ;
        if(root.left!=null)inorder(root.left);
        sorted.add(root);
        if(root.right!=null)inorder(root.right);
    }
    
    public Node treeToCircular(){
        
        Node head=sorted.get(0);
        Node temp=head;
        for(int i=0;i<sorted.size()-1;i++){
            if(i==0){
                temp.right=sorted.get(i+1);
            }else{
                temp.left=sorted.get(i-1);
                temp.right=sorted.get(i+1);
            }
            temp=temp.right;
        }
        temp.right=head;
        if(sorted.size()>1){
            temp.left=sorted.get(sorted.size()-2);
        }
        else{
            temp.left=head;
        }
        
        head.left=sorted.get(sorted.size()-1);
        return head;
}
}
