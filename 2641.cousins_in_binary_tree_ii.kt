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
  private val s: List<Int> = ArrayList()
  fun replaceValueInTree(root: TreeNode): TreeNode {
    dfs1(root, 0)
    root.`val` = 0
    dfs2(root, 1)
    return root
  }

  private fun dfs1(root: TreeNode?, d: Int) {
    if (root == null) {
      return
    }
    if (s.size() <= d) {
      s.add(0)
    }
    s.set(d, s[d] + root.`val`)
    dfs1(root.left, d + 1)
    dfs1(root.right, d + 1)
  }

  private fun dfs2(root: TreeNode?, d: Int) {
    if (root == null) {
      return
    }
    val l = if (root.left == null) 0 else root.left.`val`
    val r = if (root.right == null) 0 else root.right.`val`
    if (root.left != null) {
      root.left.`val` = s[d] - l - r
    }
    if (root.right != null) {
      root.right.`val` = s[d] - l - r
    }
    dfs2(root.left, d + 1)
    dfs2(root.right, d + 1)
  }
}
