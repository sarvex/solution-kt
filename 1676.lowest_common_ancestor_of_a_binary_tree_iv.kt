/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
internal class Solution {
  private val s: Set<Int> = HashSet()
  fun lowestCommonAncestor(root: TreeNode?, nodes: Array<TreeNode?>): TreeNode? {
    for (node in nodes) {
      s.add(node.`val`)
    }
    return dfs(root)
  }

  private fun dfs(root: TreeNode?): TreeNode? {
    if (root == null || s.contains(root.`val`)) {
      return root
    }
    val left: TreeNode? = dfs(root.left)
    val right: TreeNode? = dfs(root.right)
    if (left == null) {
      return right
    }
    return if (right == null) {
      left
    } else root
  }
}
