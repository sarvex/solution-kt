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
  fun sumNumbers(root: TreeNode?): Int {
    return dfs(root, 0)
  }

  private fun dfs(root: TreeNode?, s: Int): Int {
    var s = s
    if (root == null) {
      return 0
    }
    s = s * 10 + root.`val`
    return if (root.left == null && root.right == null) {
      s
    } else dfs(root.left, s) + dfs(root.right, s)
  }
}
