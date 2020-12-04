/**
This program merges two linked lists in a sorted order, given the node class.
 This is done using recursion, where a new linked list is created , and the
head shifts to smallest value in current position at comparisons at various positions.
TC-O(n)
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head= new ListNode(0);
        if(l1.val<l2.val){
            head=l1;
            l1=l1.next;
        }else{
            head=l2;
            l2=l2.next;
        }
        head.next=mergeTwoLists(l1,l2);
        return head;
}
}
