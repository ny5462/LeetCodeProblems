/** program to check if the given linked list is a palindrome
O(N)
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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        if(head==null)return true;
        if(head.next==null)return true;
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        for(int i=0;i<list.size()/2;i++){
            if(!list.get(i).equals(list.get(list.size()-1-i))){
                return false;
            }
        }return true;
    }
}
