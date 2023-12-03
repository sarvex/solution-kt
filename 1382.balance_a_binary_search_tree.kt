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
  private var vals: List<Int>? = null
  fun balanceBST(root: TreeNode?): TreeNode? {
    vals = ArrayList()
    dfs(root)
    return build(0, vals.size() - 1)
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    dfs(root.left)
    vals.add(root.`val`)
    dfs(root.right)
  }

  private fun build(i: Int, j: Int): TreeNode? {
    if (i > j) {
      return null
    }
    val mid = i + j shr 1
    val root = TreeNode(vals!![mid])
    root.left = build(i, mid - 1)
    root.right = build(mid + 1, j)
    return root
  }
}
