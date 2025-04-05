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
    public int solve(TreeNode root , int num){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return num*10 + root.val;
        }

        int leftSum = solve(root.left , num*10+root.val);
        int rightSum = solve(root.right , num*10 + root.val);

        return leftSum + rightSum;
    }
    
    public int sumNumbers(TreeNode root){
        return solve(root , 0);
    }
}