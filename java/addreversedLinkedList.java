/** program to add 2 LinkedList ,given in reverse manner, and return their output in reversed manner.
Done by making 2 helper functions, 1 to reverse the linked list, the other to add 2 linked List.
Credits- https://leetcode.com/problems/add-two-numbers-ii/discuss/356810/Java-Solution-O(N)-Time-O(1)-Space-Using-Reverse-Linked-List-Beats-99.80
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
        l1=reversed(l1);
        l2=reversed(l2);
        return reversed(addLinkedList(l1,l2));
    }
    
    public ListNode addLinkedList(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int carry=0;
        int sum=0;
        while(l1!=null||l2!=null||carry>0){
            sum=carry+(l1==null?0:l1.val)+(l2==null?0:l2.val);
            curr.next=new ListNode(sum%10);
            carry=sum/10;
            curr=curr.next;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
            
        }
        return dummy.next;
    }
    
    
    public ListNode reversed(ListNode head){
        if(head==null)return null;
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
} 
