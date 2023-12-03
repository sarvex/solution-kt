/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
internal class Solution {
  fun lowestCommonAncestor(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
    if (root == null || root === p || root === q) return root
    val left: TreeNode? = lowestCommonAncestor(root.left, p, q)
    val right: TreeNode? = lowestCommonAncestor(root.right, p, q)
    if (left == null) return right
    return if (right == null) left else root
  }
}
