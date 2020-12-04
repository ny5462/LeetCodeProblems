/** program to delete a node of given value from linked list
TC-O(N)
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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)return head;
        while(head.val==val){
            if(head.next==null){
                head=null;
                return head;
            }
            head=head.next;}
        ListNode current=head;
        while(current.next!=null){
            if(current.next.val==val){
                current.next=current.next.next;
            }else{current=current.next;}
        }       
        return head;
    }
}
