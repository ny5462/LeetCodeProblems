/**Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:

Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

Example 4:

Input: root = [1,2]
Output: [1,2]
credits -https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/
Done by maintaining a string for serialization by storing the tree in a  heap format of array with null values
Deserializing is done by converting that string to a queue after splitting and then dealing with values and null recursively in a heap format
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
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "X,";
        StringBuilder sb=new StringBuilder();
        rserialize(root,sb);
        System.out.println(sb.toString());
        return sb.toString();
        
    }
     public void rserialize(TreeNode root,StringBuilder sb){
         if(root==null){
             sb.append("X,");
             return;
         }
         sb.append(root.val);
         sb.append(",");
         rserialize(root.left,sb);
         rserialize(root.right,sb);
     }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q= new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode root = rdeserialize( q);
        return root;
    }
    
    public TreeNode rdeserialize (Queue<String> q){
        if(q.isEmpty())return null;
        String val=q.poll();
        if(val.equals("X"))return null;
        TreeNode node= new TreeNode(Integer.valueOf(val));
        node.left=rdeserialize(q);
        node.right=rdeserialize(q);
        return node;
            
        }
    }


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
