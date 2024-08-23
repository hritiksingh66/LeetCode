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
    public void solve(TreeNode root , int target , List<List<Integer>> ans ,List<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.val);

        if(root.left == null && root.right == null && target == root.val){
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
            list.remove(list.size()-1);
            return;
        }

        solve(root.left, target - root.val, ans , list);

        solve(root.right, target - root.val, ans , list);

        list.remove(list.size()-1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        List<Integer> temp = new ArrayList<>();

        solve(root, targetSum, ans , temp);

        return ans;
    }
}