/** program to inplace put the odd elements of LL before the even elements of a LL , in index.
Done by using node pointers and traversals.
O(N)
credits- https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/784/discuss/622066/Java-or-Constant-Space-or-0ms-100-Run-Time-or-With-Comments
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
  
public ListNode oddEvenList(ListNode head) {
    if(head==null||head.next==null)return head;
        ListNode even = head, odd = head.next; // Pointers for traversal
        ListNode ptr1 = even, ptr2 = odd; // Pointers to join 2 list later and returning

        // Example 1->2->3->4->5
        while(even != null && odd != null && even.next != null && odd.next!= null){
            even.next =  odd.next;   //1-> 3
            even = even.next;       // move pointer to next even node 3 ...
            odd.next = even.next;  //2-> 4
            odd = odd.next;       // move pointer to next odd node 4 ...
        }
        even.next = ptr2;  //  will join even and odd lists
        return ptr1;
    
    }
}
