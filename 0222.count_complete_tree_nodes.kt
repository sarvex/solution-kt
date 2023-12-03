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
internal class Solution {
  fun countNodes(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val left = depth(root.left)
    val right = depth(root.right)
    return if (left == right) {
      (1 shl left) + countNodes(root.right)
    } else (1 shl right) + countNodes(root.left)
  }

  private fun depth(root: TreeNode): Int {
    var root: TreeNode? = root
    var d = 0
    while (root != null) {
      ++d
      root = root.left
    }
    return d
  }
}
