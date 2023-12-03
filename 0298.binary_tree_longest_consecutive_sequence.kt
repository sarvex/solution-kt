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
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    var l = dfs(root.left) + 1
    var r = dfs(root.right) + 1
    if (root.left != null && root.left.`val` - root.`val` !== 1) {
      l = 1
    }
    if (root.right != null && root.right.`val` - root.`val` !== 1) {
      r = 1
    }
    val t = max(l.toDouble(), r.toDouble()).toInt()
    ans = max(ans.toDouble(), t.toDouble()).toInt()
    return t
  }
}
