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
  fun isUnivalTree(root: TreeNode): Boolean {
    return dfs(root, root.`val`)
  }

  private fun dfs(root: TreeNode?, `val`: Int): Boolean {
    return if (root == null) {
      true
    } else root.`val` === `val` && dfs(root.left, `val`) && dfs(root.right, `val`)
  }
}
