import kotlin.math.abs

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
  private var ans = 0
  fun distributeCoins(root: TreeNode?): Int {
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val left = dfs(root.left)
    val right = dfs(root.right)
    (ans += abs(left.toDouble()) + abs(right.toDouble())).toInt()
    return left + right + root.`val` - 1
  }
}
