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
  fun lcaDeepestLeaves(root: TreeNode?): TreeNode {
    return dfs(root).getKey()
  }

  private fun dfs(root: TreeNode?): Pair<TreeNode, Int> {
    if (root == null) {
      return Pair(null, 0)
    }
    val l: Pair<TreeNode, Int> = dfs(root.left)
    val r: Pair<TreeNode, Int> = dfs(root.right)
    val d1: Int = l.getValue()
    val d2: Int = r.getValue()
    if (d1 > d2) {
      return Pair(l.getKey(), d1 + 1)
    }
    return if (d1 < d2) {
      Pair(r.getKey(), d2 + 1)
    } else Pair(root, d1 + 1)
  }
}
