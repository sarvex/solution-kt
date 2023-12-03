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
  private var f: Array<List<TreeNode>?>
  fun allPossibleFBT(n: Int): List<TreeNode>? {
    f = arrayOfNulls(n + 1)
    return dfs(n)
  }

  private fun dfs(n: Int): List<TreeNode>? {
    if (f[n] != null) {
      return f[n]
    }
    if (n == 1) {
      return List.of(TreeNode())
    }
    val ans: List<TreeNode> = ArrayList()
    for (i in 0 until n - 1) {
      val j = n - 1 - i
      for (left in dfs(i)) {
        for (right in dfs(j)) {
          ans.add(TreeNode(0, left, right))
        }
      }
    }
    return ans.also { f[n] = it }
  }
}
