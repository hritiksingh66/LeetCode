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
    public boolean isBalanced(TreeNode root){

        return balanced(root).isBal;
        
    }

    public BalaPair balanced(TreeNode root){
        if(root == null){
            return new BalaPair();
        }

        BalaPair left = balanced(root.left);
        BalaPair right = balanced(root.right);

        BalaPair sbp = new BalaPair();
        sbp.ht = Math.max(left.ht , right.ht) + 1;

        boolean sb = Math.abs(left.ht - right.ht) <= 1;

        sbp.isBal = left.isBal && right.isBal && sb ;

        return sbp; 
    }

   class BalaPair{
    boolean isBal = true;
    int ht = -1;
   }

}