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
  fun heightOfTree(root: TreeNode): Int {
    dfs(root, 0)
    return ans
  }

  private fun dfs(root: TreeNode, d: Int) {
    var d = d
    ans = max(ans.toDouble(), d++.toDouble()).toInt()
    if (root.left != null && root.left.right !== root) {
      dfs(root.left, d)
    }
    if (root.right != null && root.right.left !== root) {
      dfs(root.right, d)
    }
  }
}
