/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean solve(TreeNode root, int tar) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == tar)
            return true;
        boolean leftSide = hasPathSum(root.left, tar - root.val);
        boolean rightSide = hasPathSum(root.right, tar - root.val);
        // if (leftSide || rightSide)
        //     return true;
        // else
        //     return false;
        return rightSide || leftSide;
    }

    public boolean hasPathSum(TreeNode root, int target){
        return solve(root , target);
    }
}