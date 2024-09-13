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
    public ListNode mergeKLists(ListNode[] lists){

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return Integer.compare(n1.val, n2.val); 
            }
        });


        for(ListNode li : lists){

            if(li != null){
                priorityQueue.add(li);
            }
        }

        ListNode dummy = new ListNode();

        ListNode curr = dummy;

        while(!priorityQueue.isEmpty()){
            ListNode temp = priorityQueue.poll();
            curr.next = new ListNode(temp.val);
            curr = curr.next;

           
            if(temp.next != null){
                priorityQueue.add(temp.next);
            }

        }

        return dummy.next;
    }
}