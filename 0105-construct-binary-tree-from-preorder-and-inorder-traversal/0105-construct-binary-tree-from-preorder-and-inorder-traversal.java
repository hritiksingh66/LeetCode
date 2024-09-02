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
    
    public TreeNode solve(int[] inorder, int inStart, int inEnd, 
                          int[] preorder, int preStart, int preEnd, 
                          Map<Integer, Integer> mp) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = mp.get(root.val);
        int leftVal = rootIndex - inStart;

        root.left = solve(inorder, inStart, rootIndex - 1, preorder, preStart + 1, preStart + leftVal, mp);
        root.right = solve(inorder, rootIndex + 1, inEnd, preorder, preStart + leftVal + 1, preEnd, mp);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }

        return solve(inorder, 0, inorder.length - 1, 
                     preorder, 0, preorder.length - 1, mp);
    }
}
