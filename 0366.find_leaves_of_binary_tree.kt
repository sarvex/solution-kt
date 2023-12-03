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
  fun findLeaves(root: TreeNode?): List<List<Int>> {
    val res: List<List<Int>> = ArrayList()
    val prev = TreeNode(0, root, null)
    while (prev.left != null) {
      val t: List<Int> = ArrayList()
      dfs(prev.left, prev, t)
      res.add(t)
    }
    return res
  }

  private fun dfs(root: TreeNode?, prev: TreeNode?, t: List<Int>) {
    if (root == null) {
      return
    }
    if (root.left == null && root.right == null) {
      t.add(root.`val`)
      if (prev.left === root) {
        prev.left = null
      } else {
        prev.right = null
      }
    }
    dfs(root.left, root, t)
    dfs(root.right, root, t)
  }
}
