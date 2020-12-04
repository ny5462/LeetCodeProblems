/** preorder traversal of n-array tree. DOne using recursion where first root value is added in list, followed by calling the recursive function on each of its children.
TC-O(N)
**/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
                List<Integer> nodes=new ArrayList<>();
                preorder(root,nodes);
                return nodes;
               
    }
    public void preorder(Node root,List<Integer> nodes){
        if(root==null)return;
        nodes.add(root.val);
        for(Node v:root.children){
            preorder(v,nodes);
        }          
    }
}
