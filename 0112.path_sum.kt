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
  fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    return dfs(root, targetSum)
  }

  private fun dfs(root: TreeNode?, s: Int): Boolean {
    var s = s
    if (root == null) {
      return false
    }
    s -= root.`val`
    return if (root.left == null && root.right == null && s == 0) {
      true
    } else dfs(root.left, s) || dfs(root.right, s)
  }
}
