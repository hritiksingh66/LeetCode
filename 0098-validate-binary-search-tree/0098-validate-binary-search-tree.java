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

class BstPair {
    boolean isBst = true;
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validBST(root).isBst;
    }

    public BstPair validBST(TreeNode root) {

        if (root == null) {
            return new BstPair();
        }

        BstPair left = validBST(root.left);
        BstPair right = validBST(root.right);
        BstPair self = new BstPair();

        self.max = Math.max(root.val, Math.max(right.max, left.max));
        self.min = Math.min(root.val, Math.min(right.min, left.min));

        self.isBst = left.isBst && right.isBst && (root.val > left.max && root.val < right.min);

        return self;
    }
}