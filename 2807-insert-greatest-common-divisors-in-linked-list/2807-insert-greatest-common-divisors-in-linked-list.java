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
    public static int findGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return findGCD(num2, num1 % num2);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head){

        ListNode prev = head;
        ListNode curr = head.next;

        if(head.next == null){
            return head;
        }

        while(curr != null){
           int gcd = findGCD(prev.val,curr.val);
           prev.next = new ListNode(gcd);
           prev = prev.next;
           prev.next = curr;
           prev = curr;
           curr = curr.next;
        }

        return head;
    }
}