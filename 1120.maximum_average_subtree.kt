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
  private var ans = 0.0
  fun maximumAverageSubtree(root: TreeNode?): Double {
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): IntArray {
    if (root == null) {
      return IntArray(2)
    }
    val l = dfs(root.left)
    val r = dfs(root.right)
    val s: Int = root.`val` + l[0] + r[0]
    val n = 1 + l[1] + r[1]
    ans = max(ans, s * 1.0 / n)
    return intArrayOf(s, n)
  }
}
