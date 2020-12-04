/**A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.


The iterative solution to this problem does not model it as a graph, instead simply treats it as a LinkedList. When we are iterating over the list, we can create new nodes via the random pointer or the next pointer whichever points to a node that doesn't exist in our old --> new dictionary.

Algorithm

    Traverse the linked list starting at head of the linked list.

    In the above diagram we create a new cloned head node. The cloned node is shown using dashed lines. In the implementation we would even store the reference of this newly created node in a visited dictionary.

    Random Pointer
        If the random pointer of the current node iii points to the a node jjj and a clone of jjj already exists in the visited dictionary, we will simply use the cloned node reference from the visited dictionary.
        If the random pointer of the current node iii points to the a node jjj which has not been created yet, we create a new node corresponding to jjj and add it to the visited dictionary.

    In the above diagram the random pointer of node AAA points to a node CCC. Node CCC which was not visited yet as we can see from the previous diagram. Hence we create a new cloned C′C'C′ node corresponding to node CCC and add it to visited dictionary.

    Next Pointer
        If the next pointer of the current node iii points to the a node jjj and a clone of jjj already exists in the visited dictionary, we will simply use the cloned node reference from the visited dictionary.
        If the next pointer of the current node iii points to the a node jjj which has not been created yet, we create a new node corresponding to jjj and add it to the visited dictionary.

    In the above diagram the next pointer of node AAA points to a node BBB. Node BBB which was not visited yet as we can see from the previous diagram. Hence we create a new cloned B′B'B′ node corresponding to node BBB and add it to visited dictionary.

    We repeat steps 2 and 3 until we reach the end of the linked list.

    In the above diagram, the random pointer of node BBB points to an already visited node AAA. Hence in step 2, we don't create a new copy for the clone. Instead we point random pointer of cloned node B′B'B′ to already existing cloned node A′A'A′.

    Also, the next pointer of node BBB points to an already visited node CCC. Hence in step 3, we don't create a new copy for the clone. Instead we point next pointer of cloned node B′B'B′ to already existing cloned node C′C'C′.
credits- https://leetcode.com/problems/copy-list-with-random-pointer/solution/
**/

/** class Node{
	int val;
	Node Random;
	Node next;
	
	public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }   
}
**/
class Solution{
	HashMap<Node,Node> visited=new HashMap<>();
	
	public Node getNode(Node node){
		if(node==null)return null;
		if(this.visited.containsKey(node)return this.visited.get(node);
		else{
		   this.visited.put(node, new Node(node.val,null,null);
		   return this.visited.get(node);
		}
		return null;
	}
	
	public Node copyRandomList(Node head){
     		if(head==null)return null;
     		Node oldNode=head;
     		Node node=new Node(oldNode.val,null,null);
     		
     		this.visited.put(oldNode,node);
     		while(oldNode!=null){
     			node.next=getNode(oldNode.next);
     			node.random=getNode(oldNode.random);
     			
     			oldNode=oldNode.next;
     			node=node.next;
     		}
     		return this.visited.get(head);
     				
     
	}

}
