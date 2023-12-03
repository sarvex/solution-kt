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
  private val cnt: Map<Long, Int> = HashMap()
  private var targetSum = 0
  fun pathSum(root: TreeNode?, targetSum: Int): Int {
    cnt.put(0L, 1)
    this.targetSum = targetSum
    return dfs(root, 0)
  }

  private fun dfs(node: TreeNode?, s: Long): Int {
    var s = s
    if (node == null) {
      return 0
    }
    s += node.`val`
    var ans = cnt[s - targetSum] ?: 0
    cnt.merge(s, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    ans += dfs(node.left, s)
    ans += dfs(node.right, s)
    cnt.merge(s, -1) { a: Int, b: Int -> Integer.sum(a, b) }
    return ans
  }
}
