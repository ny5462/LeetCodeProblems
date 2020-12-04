/** Program to find the Node at which two linked Lists intersect, if none, then return 
null.Stored 1st linked list a hashset, and checked while traversing other linked list,
whether a node exists in the hashset.
 TC-O(N)
**/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null ||headB==null)return null;
        Set<ListNode> Set2=new HashSet<>();
        while(headB!=null){
            Set2.add(headB);
            headB=headB.next;
        }
        while(headA!=null){
            if(Set2.contains(headA)){
                return headA;
            }else{
                headA=headA.next;
            }
        }
        return headA;
    }
}
