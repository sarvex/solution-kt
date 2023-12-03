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
  private var ans = -1001
  fun maxPathSum(root: TreeNode?): Int {
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val left = max(0.0, dfs(root.left).toDouble()).toInt()
    val right = max(0.0, dfs(root.right).toDouble()).toInt()
    ans = Math.max(ans, root.`val` + left + right)
    return root.`val` + max(left.toDouble(), right.toDouble())
  }
}
