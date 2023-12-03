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
  private var ans = 0
  fun longestConsecutive(root: TreeNode?): Int {
    ans = 0
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): IntArray {
    if (root == null) {
      return intArrayOf(0, 0)
    }
    var incr = 1
    var decr = 1
    val left = dfs(root.left)
    val right = dfs(root.right)
    if (root.left != null) {
      if (root.left.`val` + 1 === root.`val`) {
        incr = left[0] + 1
      }
      if (root.left.`val` - 1 === root.`val`) {
        decr = left[1] + 1
      }
    }
    if (root.right != null) {
      if (root.right.`val` + 1 === root.`val`) {
        incr = max(incr.toDouble(), (right[0] + 1).toDouble()).toInt()
      }
      if (root.right.`val` - 1 === root.`val`) {
        decr = max(decr.toDouble(), (right[1] + 1).toDouble()).toInt()
      }
    }
    ans = max(ans.toDouble(), (incr + decr - 1).toDouble()).toInt()
    return intArrayOf(incr, decr)
  }
}
