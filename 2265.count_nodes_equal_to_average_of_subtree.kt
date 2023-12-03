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
  private var ans = 0
  fun averageOfSubtree(root: TreeNode?): Int {
    ans = 0
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): IntArray {
    if (root == null) {
      return intArrayOf(0, 0)
    }
    val l = dfs(root.left)
    val r = dfs(root.right)
    val s: Int = l[0] + r[0] + root.`val`
    val n = l[1] + r[1] + 1
    if (s / n == root.`val`) {
      ++ans
    }
    return intArrayOf(s, n)
  }
}
