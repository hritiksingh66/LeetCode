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
    public int numComponents(ListNode head, int[] nums){

        if(head.next == null){
            return 1;
        }

        int count = nums.length;
        boolean flag = false;

        Map<Integer,Integer> mp = new HashMap<>();

        for(int val : nums){
            mp.put(val,null);
        }

        int result = 0;

        while(head!=null){
            if(mp.containsKey(head.val)){
                if(flag){
                    count--;
                }else{
                    flag = true;
                }
            }else{
                flag = false;
            }
            head = head.next;
        }
        return count;
    }
}