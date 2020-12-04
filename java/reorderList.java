/**Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.
Done using three steps, first find middle of list using fast and slow pointers, second reverse the second half of list, third merge two list with elements taken alternatively from each side.
EASY TO UNDERSTAND WHEN DRAWN, ESP REVERSING AND MERGING
credits- https://leetcode.com/problems/reorder-list/solution/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null)return;
        //find the middle
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        // reverse the linked list
        ListNode prev=null;
        ListNode curr=slow;
        ListNode tmp=curr.next;
        while(curr!=null){
            tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
        // merge two lists alternatively
        ListNode first=head;
        ListNode second=prev;
        tmp=null;
        while(second.next!=null){
           tmp=first.next;
           first.next=second;
           first=tmp;
           
          tmp=second.next;
          second.next=first;
            second=tmp;
           
        }
    }
}
