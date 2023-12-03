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
  fun maxAncestorDiff(root: TreeNode): Int {
    dfs(root, root.`val`, root.`val`)
    return ans
  }

  private fun dfs(root: TreeNode?, mi: Int, mx: Int) {
    var mi = mi
    var mx = mx
    if (root == null) {
      return
    }
    val x: Int = Math.max(Math.abs(mi - root.`val`), Math.abs(mx - root.`val`))
    ans = max(ans.toDouble(), x.toDouble()).toInt()
    mi = Math.min(mi, root.`val`)
    mx = Math.max(mx, root.`val`)
    dfs(root.left, mi, mx)
    dfs(root.right, mi, mx)
  }
}
