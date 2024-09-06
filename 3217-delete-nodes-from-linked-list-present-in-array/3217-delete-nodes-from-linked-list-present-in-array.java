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
    public ListNode modifiedList(int[] nums, ListNode head){
        Map<Integer,Integer> mp = new HashMap<>();

        for(int ele : nums){
            mp.putIfAbsent(ele,1);
        }

        ListNode prev = head;
        ListNode curr = head.next;


        while(curr != null){
            if(mp.containsKey(curr.val)){
                curr = curr.next;
                prev.next = curr;
            }else{
                prev = prev.next;
                curr = curr.next;
            }
        }

        if(mp.containsKey(head.val)){
            return head.next;
        }

        return head;
    }
}