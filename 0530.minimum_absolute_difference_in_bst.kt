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
  private var prev = 0
  private val inf = Int.MAX_VALUE
  fun getMinimumDifference(root: TreeNode?): Int {
    ans = inf
    prev = inf
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    dfs(root.left)
    ans = Math.min(ans, Math.abs(root.`val` - prev))
    prev = root.`val`
    dfs(root.right)
  }
}
