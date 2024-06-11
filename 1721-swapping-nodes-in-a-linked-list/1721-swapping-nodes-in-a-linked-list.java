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
        ListNode temp = head;
        
        int L = 0;
        while(temp!=null){
            L =  L+1;
            temp = temp.next;
        }
        
        temp = head;
        ListNode Node1 = null;
        ListNode Node2 = null;
        while(temp!=null){
            if(Node2!=null){
                Node2 = Node2.next; 
            }
            k--;
            if(k==0){
                Node1 = temp;
                Node2 = head;
            }
            
            temp = temp.next;
        }
        
        int t = Node1.val;
        Node1.val = Node2.val;
        Node2.val = t;
        
        return head;
    }
}