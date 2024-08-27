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
    public void dfsRecursive(TreeNode node, int level){
        if(ans.size() == level) {
            ans.add(node.val);
        }
        if(node.right!=null) dfsRecursive(node.right, level+1);
        if(node.left!=null) dfsRecursive(node.left, level+1);
        
        
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return ans;
        }

        dfsRecursive(root, 0);
        return ans;
    }
}