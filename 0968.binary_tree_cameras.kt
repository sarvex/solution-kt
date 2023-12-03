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
  fun minCameraCover(root: TreeNode?): Int {
    val ans = dfs(root)
    return min(ans[0].toDouble(), ans[1].toDouble()).toInt()
  }

  private fun dfs(root: TreeNode?): IntArray {
    if (root == null) {
      return intArrayOf(1 shl 29, 0, 0)
    }
    val l = dfs(root.left)
    val r = dfs(root.right)
    val a = (1 + min(min(l[0].toDouble(), l[1].toDouble()), l[2].toDouble()) + min(
      min(
        r[0].toDouble(), r[1].toDouble()
      ), r[2].toDouble()
    )).toInt()
    val b = min(min((l[0] + r[1]).toDouble(), (l[1] + r[0]).toDouble()), (l[0] + r[0]).toDouble())
      .toInt()
    val c = l[1] + r[1]
    return intArrayOf(a, b, c)
  }
}
