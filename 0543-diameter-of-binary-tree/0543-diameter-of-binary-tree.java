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
    class Pair{
        int h = 0;
        int d = 0;
    }

    public Pair solve(TreeNode root){
        if(root == null){
            return new Pair();
        }

        Pair lp = solve(root.left);
        Pair rp = solve(root.right);

        Pair sp = new Pair();
        sp.h = Math.max(lp.h , rp.h) +1;
        sp.d = Math.max(lp.h + rp.h , Math.max(lp.d , rp.d));
        return sp;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Pair  ans = solve(root);
        return ans.d;
    }

}