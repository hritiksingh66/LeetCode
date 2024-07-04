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
    public ListNode mergeNodes(ListNode head){
        ListNode left = head.next;
        ListNode right = left;


        // if(head.next.next.next == null){
        //     head.next.next = null;
        //     return head.next;
        // }

        while(right!=null){

            int sum = 0;
            while(right!=null && right.val!=0){
                sum += right.val;
                right = right.next;
            }

            left.val = sum;
            right = right.next;
            left.next = right;
            left = left.next;
        }
        return head.next;
    }
}