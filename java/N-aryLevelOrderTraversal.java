/** n-ary tree level order traversal. DOne using BFS maintaining a queue and a list of list to be returned
TC-O(N)
**/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q=new ArrayDeque<>();
        List<List<Integer>> l= new ArrayList<>();
        if(root==null)return l;
        q.add(root);
        List<Integer> head=new ArrayList<>();
        head.add(root.val);
        l.add(head);
        while(!q.isEmpty()){
            int size=q.size();   
            List<Integer> child=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node n=q.poll();
                for(Node branch:n.children){
                     if(branch!=null){   
                        q.add(branch);
                        child.add(branch.val);
                }
                }
               
            }
            if(child.size()>0)l.add(child);
            
        }
        return l;
    }
}
