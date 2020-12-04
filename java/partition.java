/**Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

Done by producing two independent linkedlists, one with values less than x, and one with value greater than or equal to x.
As we iterate the linked list, we keep on adding elements to their respective lists according to the value.
Once the entire list is iterated, we append larger list to the tail of smaller list.
TC-O(N)
**/
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
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)return head;
        // head of small list, tail of small list, head of larger list, tail of larger list, iterator for input list
        ListNode smaller=null, stemp=null,larger=null, ltemp=null, curr=head;
        while(curr!=null){
            if(curr.val>=x){
            // first element in large list added
                if(larger==null){
                    larger=new ListNode(curr.val);
                    ltemp=larger;
                }
                // element added in larger list
                else{
                    ltemp.next=new ListNode(curr.val);
                    ltemp=ltemp.next;
                }
            }
            else{
            // first element added in smaller list
                if(smaller==null){
                    smaller=new ListNode(curr.val);
                    stemp=smaller;
                }
                // element added to tail of smaller list
                else{
                    stemp.next=new ListNode(curr.val);
                    stemp=stemp.next;
                }
            }
            curr=curr.next;
        }
        // if smaller list is not empty, we append larger list to its tail else return larger list
        if(stemp!=null){
            stemp.next=larger;
            return smaller;
        }else{
            return larger;
        }
    }
}
