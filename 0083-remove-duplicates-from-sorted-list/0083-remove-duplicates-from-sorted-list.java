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
    public ListNode deleteDuplicates(ListNode head){
        if(head==null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode temp = head.next;
        ListNode currHead = head;
        

        while(temp != null){
            if(currHead.val != temp.val){
                currHead.next = temp;
                currHead = currHead.next;
            }
            temp = temp.next;
        }

        currHead.next = null;

        return head;
    }
}