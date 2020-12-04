/** program to merge k linkedlists, and return them in sorted order. Done using priority queue, where he head of all the lists is added to pq initially, then after each extraction, the element next to the extracted node is added on the list. Therefore, every processed minimum will end up giving a sorted Linked List. only k elements are present in queue at a time. hence log K.
TC-O(NlogK)
**/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode l :lists){
            if(l!=null){
                pq.add(l);
            }
        }
        ListNode node=new ListNode(0);
        ListNode head=node;
        while(!pq.isEmpty()){
            node.next=pq.poll();
            node=node.next;
            ListNode temp=node.next;
            if(temp!=null)pq.add(temp);
        }
        return head.next;
    }
}
