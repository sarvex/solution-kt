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
  fun countUnivalSubtrees(root: TreeNode?): Int {
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): Boolean {
    if (root == null) {
      return true
    }
    val l = dfs(root.left)
    val r = dfs(root.right)
    if (!l || !r) {
      return false
    }
    val a: Int = if (root.left == null) root.`val` else root.left.`val`
    val b: Int = if (root.right == null) root.`val` else root.right.`val`
    if (a == b && b == root.`val`) {
      ++ans
      return true
    }
    return false
  }
}
