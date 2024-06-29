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
    public ListNode reverseList(ListNode head){
        ListNode ansNode = new ListNode();
        ansNode = null;
        ListNode temp = head;
        ListNode temp1 = ansNode;
        while(temp!=null){
            ListNode a = new ListNode(temp.val);
            a.next = temp1;
            temp1=a;
            temp = temp.next;
        }
        return temp1;
    }
}