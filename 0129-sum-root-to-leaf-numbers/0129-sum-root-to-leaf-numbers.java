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
    // static int sum = 0;
    public int solve(TreeNode root , int sum){
        if(root == null) return 0;
        sum = sum*10 + root.val;

        if(root.left == null && root.right == null)
            return sum;

        int a = solve(root.left , sum);
        int b = solve(root.right , sum);

        return a+b;
    }

    public int sumNumbers(TreeNode root){

        return solve(root , 0);
    }
        
}

