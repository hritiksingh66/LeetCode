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
    public int[] nodesBetweenCriticalPoints(ListNode head){
        ListNode prev = head;
        ListNode curr = head.next;
        
        int i = 1;

        int prevCriticalPoint = 0;
        int firstCriticalPoint = 0;

        int minDist = Integer.MAX_VALUE;

        while(curr.next!=null){

            if((curr.val < curr.next.val && curr.val < prev.val) || (curr.val > curr.next.val && curr.val > prev.val)){

                if(prevCriticalPoint==0){
                    firstCriticalPoint = i;
                    prevCriticalPoint = i;
                }else{
                    minDist = Math.min(minDist , i - prevCriticalPoint);
                    prevCriticalPoint = i;
                }
            }

            i++;
            prev = curr;
            curr = curr.next;
        }

        if(minDist == Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }

        return new int[]{minDist , prevCriticalPoint - firstCriticalPoint};
    }
}