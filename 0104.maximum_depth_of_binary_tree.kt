import kotlin.math.max

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
  fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val l = maxDepth(root.left)
    val r = maxDepth(root.right)
    return (1 + max(l.toDouble(), r.toDouble())).toInt()
  }
}
