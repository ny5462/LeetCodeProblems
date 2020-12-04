/** program to add 2 reverse numbers in Linked List , done using use of head and tail pointers.
TC-O(max(l1,l2))
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
        ListNode head=null;
        ListNode tail=null;
        ListNode l3=null;
        int carry=0;
        int size=0;
        int num; 
        if(l1==null)return l2;
        if(l2==null)return l1;
        num=l1.val+l2.val+carry;
        if(num>=10){
            carry=1;num=num%10;
            }
        head=new ListNode(num);
        tail=head;
        size++;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null||l2!=null){
            if(l1==null&&l2!=null){
                num=l2.val+carry;
                if(num>=10){
                    carry=1;num=num%10;
                }else carry=0;
                l3=new ListNode(num);
            }
            
            else if(l1!=null&&l2==null){
                num=l1.val+carry;
                if(num>=10){
                    carry=1; num=num%10;
                }else carry=0;
                l3= new ListNode(num);
            }
            else if(l1!=null&&l2!=null){
                num=l1.val+l2.val+carry;
                if(num>=10){
                    carry=1;num=num%10;
                }else carry=0;
                l3=new ListNode(num);
            }
            
            size++;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
            tail.next=l3;
            tail=l3;
            //if(size==2)head.next=tail;
        }
        if(carry==1){
            l3=new ListNode(1);
            tail.next=l3;
            tail=l3;
        }
        return head;
    }
}


/** a much better solution with concise code
credits- leetcode discuss
**/


/** program to add 2 reverse numbers in Linked List , done using use of head and tail pointers.
TC-O(max(l1,l2))
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
        int carry=0;
        ListNode temp=l1;
        while(l1!=null||l2!=null){
            int n1=l1==null?0:l1.val;
            int n2=l2==null?0:l2.val;
            int sum=n1+n2+carry;
            l1.val=sum%10;
            carry=sum/10;
            if(l1.next==null&&(carry>0||(l2!=null&&l2.next!=null))){
                l1.next=new ListNode(0);
            }
            if(l1!=null){
                l1=l1.next;
            }if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry>0){
            l1.next=new ListNode(carry);
        }return temp;
    }
}
