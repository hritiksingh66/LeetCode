public class Solution {
    public ListNode detectCycle(ListNode head){
        if(head==null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) break;
        }
        
        if(slow!=fast) return null;
        
        ListNode curr = head;
        while(curr!=slow){
            curr = curr.next;
            slow = slow.next;
        }
        
        return slow;
    }
}