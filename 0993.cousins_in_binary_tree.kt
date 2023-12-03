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
  private var x = 0
  private var y = 0
  private var p1: TreeNode? = null
  private var p2: TreeNode? = null
  private var d1 = 0
  private var d2 = 0
  fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    this.x = x
    this.y = y
    dfs(root, null, 0)
    return p1 !== p2 && d1 == d2
  }

  private fun dfs(root: TreeNode?, p: TreeNode?, d: Int) {
    if (root == null) {
      return
    }
    if (root.`val` === x) {
      p1 = p
      d1 = d
    }
    if (root.`val` === y) {
      p2 = p
      d2 = d
    }
    dfs(root.left, root, d + 1)
    dfs(root.right, root, d + 1)
  }
}
