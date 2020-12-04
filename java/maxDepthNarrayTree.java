/** program to find maximum depth of N-array tree. Done using recursion. could be done using BFS as well. credits to https://leetcode.com/problems/maximum-depth-of-n-ary-tree/discuss/334318/Java-DFS-Solution
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
   public int maxDepth(Node root){
       if(root==null)return 0;
       int max=0;
       for(Node n:root.children){
           max=Math.max(maxDepth(n),max);
       }
       return 1+max;
   }
    
}
