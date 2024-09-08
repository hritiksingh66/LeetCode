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
    public ListNode[] splitListToParts(ListNode head, int k){
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        int eachBucketNode = len / k;

        int remainNodes = len % k;


        ListNode[] ans = new ListNode[k];
        Arrays.fill(ans,null);

        curr = head;
        ListNode prev = null;

        for(int i = 0 ; i < k; i++){
            ans[i] = curr;

            for(int j = 1; j <= eachBucketNode + (remainNodes > 0 ? 1 : 0) ; j++){
                prev = curr;
                curr = curr.next;
            }

            if(prev != null){
                prev.next = null;
            }

            remainNodes--;
        }

        return ans;
    }
}