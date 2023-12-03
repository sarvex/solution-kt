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
  private var `val` = 0
  private var depth = 0
  fun addOneRow(root: TreeNode, `val`: Int, depth: Int): TreeNode {
    if (depth == 1) {
      return TreeNode(`val`, root, null)
    }
    this.`val` = `val`
    this.depth = depth
    dfs(root, 1)
    return root
  }

  private fun dfs(root: TreeNode?, d: Int) {
    if (root == null) {
      return
    }
    if (d == depth - 1) {
      val l = TreeNode(`val`, root.left, null)
      val r = TreeNode(`val`, null, root.right)
      root.left = l
      root.right = r
      return
    }
    dfs(root.left, d + 1)
    dfs(root.right, d + 1)
  }
}
