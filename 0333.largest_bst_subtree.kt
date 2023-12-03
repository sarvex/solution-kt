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
  fun largestBSTSubtree(root: TreeNode?): Int {
    ans = 0
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): IntArray {
    if (root == null) {
      return intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE, 0)
    }
    val left = dfs(root.left)
    val right = dfs(root.right)
    if (left[1] < root.`val` && root.`val` < right[0]) {
      ans = max(ans.toDouble(), (left[2] + right[2] + 1).toDouble()).toInt()
      return intArrayOf(
        Math.min(root.`val`, left[0]), Math.max(root.`val`, right[1]), left[2] + right[2] + 1
      )
    }
    return intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE, 0)
  }
}
