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
  fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    return if (root == null) {
      false
    } else (dfs(root, subRoot) || isSubtree(root.left, subRoot)
        || isSubtree(root.right, subRoot))
  }

  private fun dfs(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null && root2 == null) {
      return true
    }
    return if (root1 == null || root2 == null) {
      false
    } else (root1.`val` === root2.`val` && dfs(root1.left, root2.left)
        && dfs(root1.right, root2.right))
  }
}
