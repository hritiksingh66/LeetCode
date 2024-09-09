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
    public int[][] spiralMatrix(int m, int n, ListNode head){

        int[][] ans = new int[m][n];
        for(int[] arr : ans){
            Arrays.fill(arr , -1);
        }

        if(head == null){
            return ans;
        }

        int topRow = 0,bottomRow = m - 1, leftCol = 0 , rightCol = n-1;

        while(head != null){

            //TopRow -> leftCol se RightCol jaana hai 
            for(int i = leftCol ; i <=rightCol && head !=null ; i++){
                ans[topRow][i] = head.val;
                head = head.next;
            }
            topRow++;

            //RightCol -> topRow se bottomRow jaana hai 
            for(int i = topRow ; i <= bottomRow && head !=null ; i++){
                ans[i][rightCol] = head.val;
                head = head.next;
            }
            rightCol--;

            //BottomRow -> RightCol se leftCol jaana hai 
            for(int i = rightCol ; i >= leftCol && head !=null ; i--){
                ans[bottomRow][i] = head.val;
                head = head.next;
            }
            bottomRow--;

            //leftCol -> bottomRow se topRow jaana hai 
            for(int i = bottomRow ; i >= topRow && head !=null ; i--){
                ans[i][leftCol] = head.val;
                head = head.next;
            }
            leftCol++;
        }

        return ans;
        
    }
}