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
class Solution{
    private int result = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return result;
    }

    public int solve(TreeNode root){
        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        result = Math.max(result , right + left);

        return Math.max(right , left) + 1;
    }


}