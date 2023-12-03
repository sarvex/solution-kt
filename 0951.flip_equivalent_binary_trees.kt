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
  fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
    return dfs(root1, root2)
  }

  private fun dfs(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 === root2 || root1 == null && root2 == null) {
      return true
    }
    return if (root1 == null || root2 == null || root1.`val` !== root2.`val`) {
      false
    } else dfs(root1.left, root2.left) && dfs(root1.right, root2.right) || dfs(
      root1.left,
      root2.right
    ) && dfs(root1.right, root2.left)
  }
}
