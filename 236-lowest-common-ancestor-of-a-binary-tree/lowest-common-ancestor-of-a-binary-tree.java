/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode(int x) {
 *         val = x;
 *     }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If current node is null, p, or q, return it.
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search for p and q in the left and right subtrees.
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);

        // One node was found on each side.
        // Therefore, root is their lowest common ancestor.
        if (leftResult != null && rightResult != null) {
            return root;
        }

        // Both nodes are on the same side, or only one is found below.
        return leftResult != null ? leftResult : rightResult;
    }
}