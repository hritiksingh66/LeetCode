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

    int visitedLevel = -1;

    public void solve(TreeNode root,int currLevel , List<Integer> ans){

        if(root == null) return;

        if(currLevel > visitedLevel){
            ans.add(root.val);
            visitedLevel = currLevel; 
        }

        solve(root.right ,currLevel + 1 , ans);
        solve(root.left , currLevel + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root){
        List<Integer> ans = new ArrayList<>();

        solve(root, 0, ans);

        return ans;
    }
}