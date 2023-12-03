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
  fun longestZigZag(root: TreeNode?): Int {
    dfs(root, 0, 0)
    return ans
  }

  private fun dfs(root: TreeNode?, l: Int, r: Int) {
    if (root == null) {
      return
    }
    ans = max(ans.toDouble(), max(l.toDouble(), r.toDouble())).toInt()
    dfs(root.left, r + 1, 0)
    dfs(root.right, 0, l + 1)
  }
}
