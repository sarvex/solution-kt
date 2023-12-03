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
  private val vis: Set<Int> = HashSet()
  private var k = 0
  fun findTarget(root: TreeNode?, k: Int): Boolean {
    this.k = k
    return dfs(root)
  }

  private fun dfs(root: TreeNode?): Boolean {
    if (root == null) {
      return false
    }
    if (vis.contains(k - root.`val`)) {
      return true
    }
    vis.add(root.`val`)
    return dfs(root.left) || dfs(root.right)
  }
}
