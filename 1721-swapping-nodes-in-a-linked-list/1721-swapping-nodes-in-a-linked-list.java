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
    public ListNode swapNodes(ListNode head, int k){
        ListNode dummy = head;
        
        int L = 0;
        while(dummy!=null){
            L =  L+1;
            dummy = dummy.next;
        }
        
        //Kth Node from Start
        int k_1 = k;
        ListNode Node1 = head;
        while(k_1>1){
            Node1 = Node1.next;
            k_1--;
        }
        
        //Kth Node from Last
        int k_2 = (L-k)+1;
        ListNode Node2 = head;
        
        while(k_2>1){
            Node2 = Node2.next;
            k_2--;
        }
        
        int temp = Node1.val;
        Node1.val = Node2.val;
        Node2.val = temp;
        
        return head;
    }
}