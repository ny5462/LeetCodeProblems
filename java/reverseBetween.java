/** reverse a linkedlist between 2 given indices
Done by first finding a node before the first index, and a node after the last index range and saving them
Now sending the nodes to be reversed from the first index. After reversed list is returned, we traverse the reversed list and append to it the node after the last index range, after that we append the reversed list to the node before the first index.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	//stores node at m, node at n, iterator, m-1, n+1
        ListNode first=null, second=null,curr=head; ListNode prevFirst=null; ListNode nextSecond=null;
        int index=1;
        //iterate through list to find mth element, m-1th, n, and n+1th
        while(index!=n+1){
            // m-1 is found
            if(index==m-1){
                prevFirst=curr;
               // mth element found
            }if(index==m){
                first=curr;
            }
            //nth element is found, and we store its next pointer, and while sending it to reverse, we make its next pointer to null
            // so that effective reverse is performed.
            if(index==n){
                second=curr;
                nextSecond=curr.next;
                second.next=null;
            }
            curr=curr.next;
            index++;
        }
        // getting the reversed list
        ListNode reversed = reverse(first); 
        // appending the tail elements to reversed list after iterating till tail of reversed list
        ListNode temp=reversed;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=nextSecond;
        //attaching tail of m-1th list, that was unchanged to head of reversed list.
        if(prevFirst!=null){
            prevFirst.next=reversed;
        }if(prevFirst==null)return reversed;
        return head;   
        
    }
    
    // reversing a linked list
    public ListNode reverse(ListNode first){
        ListNode curr=first;
        ListNode next=null,prev=null;
        while(curr!=null){
            //swapping pointers
            next=curr.next;
            curr.next=prev;
            //change order to perform for next iteration
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
