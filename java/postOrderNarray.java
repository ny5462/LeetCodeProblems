/** program to perform post order traversal of n array tree.Done using recursion, first all the children are traversed and added using recursive function, then the root is added on the list.
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
    public List<Integer> postorder(Node root) {
        List<Integer> nodes=new ArrayList<>();
        post(root,nodes);
        return nodes;
        }
    public void post(Node root,List<Integer> nodes){
        if(root==null)return;
        for(Node v: root.children){
            post(v,nodes);
        }
        nodes.add(root.val);
    }
}
