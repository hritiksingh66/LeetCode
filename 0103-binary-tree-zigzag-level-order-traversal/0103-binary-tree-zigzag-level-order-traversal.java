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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int l = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i < s) {
                TreeNode k = q.poll();
                if (l%2==0) {
                    temp.add(k.val);
                } else {
                    temp.add(0,k.val);
                }

                if (k.left != null) {
                    q.offer(k.left);
                }

                if (k.right != null) {
                    q.offer(k.right);
                }
                i++;
            }
            ans.add(temp);
            l++;
        }

        return ans;
    }
}