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
    private int ans = 0;
    public void solve(TreeNode root, int sum){
        sum = sum*2 + root.val;
        if(root.left == null && root.right == null){
            System.out.println(sum);
            ans += sum;
            return;
        }

        if(root.left!=null) solve(root.left , sum);
        if(root.right!=null)solve(root.right , sum);
    }
    public int sumRootToLeaf(TreeNode root){
        ans = 0;
        solve(root, 0);
        return ans;
    }
}