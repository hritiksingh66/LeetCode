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
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode mergeSortedList(ListNode l1,ListNode l2){
        if(l1==null || l2==null){
            return (l1==null)?l2:l1;
        }
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next; 
        }
        
        curr.next = l1!=null?l1:l2;
        
        return ans.next;
    } 
    public ListNode sortList(ListNode head){
        if(head == null || head.next==null) return head;
        
        ListNode mid = findMid(head);
        ListNode newhead = mid.next;
        mid.next=null;
        
        ListNode left_half = sortList(head);
        ListNode right_half = sortList(newhead);
        
        return mergeSortedList(left_half,right_half);
    }
}