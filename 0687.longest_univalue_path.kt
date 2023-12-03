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
  fun longestUnivaluePath(root: TreeNode?): Int {
    ans = 0
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    var left = dfs(root.left)
    var right = dfs(root.right)
    left = if (root.left != null && root.left.`val` === root.`val`) left + 1 else 0
    right = if (root.right != null && root.right.`val` === root.`val`) right + 1 else 0
    ans = max(ans.toDouble(), (left + right).toDouble()).toInt()
    return max(left.toDouble(), right.toDouble()).toInt()
  }
}
