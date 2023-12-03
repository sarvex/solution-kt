import kotlin.math.min

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
  fun minDepth(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    if (root.left == null) {
      return 1 + minDepth(root.right)
    }
    return if (root.right == null) {
      1 + minDepth(root.left)
    } else (1 + min(minDepth(root.left).toDouble(), minDepth(root.right).toDouble())).toInt()
  }
}
