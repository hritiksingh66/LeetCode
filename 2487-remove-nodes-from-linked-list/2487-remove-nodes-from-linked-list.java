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
    public ListNode removeNodes(ListNode head){
       head = reverse(head);

       ListNode prev = head; 
       ListNode curr = head.next;

       while(curr != null){
            while(curr != null && prev.val > curr.val){
                curr = curr.next;
            }
            prev.next = curr;
            if (curr != null) {
                prev = curr;
                curr = curr.next;
            }
       }

       return reverse(head);
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;

        ListNode ans = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = ans;
            ans = curr;
            curr = next;
        }
        return ans;
    }
}