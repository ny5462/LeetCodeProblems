/** program to check if linked list has a cycle
approach using hash table and storing nodes, and checking if it reappears
approach 2 using dual pointers
TC-O(N)
**/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
    Set<ListNode> seen=new HashSet<>();
    while(head!=null){
        if(seen.contains(head))return true;
        else seen.add(head);
        head=head.next;
    }
        return false;
}
}
    
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
        
       }
       return true;
       }
    }
    return true;
}
