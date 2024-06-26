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
     TreeNode solve(int l, int r, int[] arr) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = solve(l, mid - 1, arr);
        root.right = solve(mid + 1, r, arr);

        return root;
    }

   void inOrder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inOrder(root.left, arr); // L
        arr.add(root.val); // V
        inOrder(root.right, arr); // R
    }
    public TreeNode balanceBST(TreeNode root){

        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);

        int l = 0;
        int r = arr.size() - 1;
 
        int[] array = arr.stream().mapToInt(i -> i).toArray();

        return solve(l, r, array);
    }
}