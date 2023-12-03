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
  fun pseudoPalindromicPaths(root: TreeNode?): Int {
    return dfs(root, 0)
  }

  private fun dfs(root: TreeNode?, mask: Int): Int {
    var mask = mask
    if (root == null) {
      return 0
    }
    mask = mask xor (1 shl root.`val`)
    return if (root.left == null && root.right == null) {
      if (mask and mask - 1 == 0) 1 else 0
    } else dfs(root.left, mask) + dfs(root.right, mask)
  }
}
