import kotlin.math.max
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
  private var ans = 0
  private val inf = 1 shl 30
  fun maxSumBST(root: TreeNode?): Int {
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): IntArray {
    if (root == null) {
      return intArrayOf(1, inf, -inf, 0)
    }
    val l = dfs(root.left)
    val r = dfs(root.right)
    val v: Int = root.`val`
    if (l[0] == 1 && r[0] == 1 && l[2] < v && r[1] > v) {
      val s = v + l[3] + r[3]
      ans = max(ans.toDouble(), s.toDouble()).toInt()
      return intArrayOf(
        1, min(l[1].toDouble(), v.toDouble()).toInt(), max(r[2].toDouble(), v.toDouble())
          .toInt(), s
      )
    }
    return IntArray(4)
  }
}
