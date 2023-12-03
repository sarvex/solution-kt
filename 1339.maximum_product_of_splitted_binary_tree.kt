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
  private var ans: Long = 0
  private var s: Long = 0
  fun maxProduct(root: TreeNode?): Int {
    val mod = 1e9.toInt() + 7
    s = sum(root)
    dfs(root)
    return (ans % mod).toInt()
  }

  private fun dfs(root: TreeNode?): Long {
    if (root == null) {
      return 0
    }
    val t: Long = root.`val` + dfs(root.left) + dfs(root.right)
    if (t < s) {
      ans = max(ans.toDouble(), (t * (s - t)).toDouble()).toLong()
    }
    return t
  }

  private fun sum(root: TreeNode?): Long {
    return if (root == null) {
      0
    } else root.`val` + sum(root.left) + sum(root.right)
  }
}
