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
    List<Integer> ans = new ArrayList<>();
    public void solve(TreeNode root,int level){
        if(root == null){
            return;
        }
        if(ans.size() == level){
            ans.add(root.val);
        }

        if(root.right!=null) solve(root.right,level+1);
        if(root.left!=null) solve(root.left,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        solve(root,0);
        return ans;
        
    }
}