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

    public TreeNode buildTree(int[] preorder,int[] inorder){
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) { // base case
            return null;
        }

        int rootVal = preorder[preStart]; // root node value is the first element in preorder array
        TreeNode root = new TreeNode(rootVal); // create a new TreeNode with root node value

        // Find the index of the root in the inorder array linearly 
        int rootIndex = 0; 
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inStart; // Number of nodes in the left subtree

        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1); // Left subtree
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd); // Right subtree

        return root;
    }
}