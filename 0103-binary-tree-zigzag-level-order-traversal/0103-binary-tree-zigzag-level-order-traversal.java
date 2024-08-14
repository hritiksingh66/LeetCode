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

        boolean flag = true;
        while (!q.isEmpty()) {
            int s = q.size();
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i < s) {
                TreeNode k = q.poll();
                if (flag) {
                    temp.add(k.val);
                } else {
                    temp.addFirst(k.val);
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
            flag = !flag;
        }

        return ans;
    }
}