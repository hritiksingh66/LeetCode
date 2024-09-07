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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return solveDFS(head, head, root);  // Start DFS search
    }

    // DFS helper function
    boolean solveDFS(ListNode head, ListNode cur, TreeNode root) {
        // List ke last me pahuch jaane par true return krenge (successful match)
        if (cur == null) return true;
        // yadi bina pura list match karey , hm tree ke path ke last me pahuch jaate hain to false return karenge 
        if (root == null) return false;
        
        // curr tree Node ko curr List node se match karenge
        if (cur.val == root.val) cur = cur.next;

        // yadi koi match nii hota hai, lekin tree node linked list ka head se match kar jata hai toh new match karana start karenge
        else if (head.val == root.val) head = head.next;
        // warna , curr ko head pr reset karenge taaki list ka matching scratch se ho paaye
        else cur = head;

        // dono left and right children ke liye DFS down search karenge
        return solveDFS(head, cur, root.left) || solveDFS(head, cur, root.right);
    }
}