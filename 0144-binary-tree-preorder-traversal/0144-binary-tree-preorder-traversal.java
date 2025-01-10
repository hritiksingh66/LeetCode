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
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
       
        while(root != null){
            ans.add(root.val);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left == null && !st.isEmpty()){
                root = st.pop();
            }else{
                root = root.left;
            }
        }

        return ans;
    }
}