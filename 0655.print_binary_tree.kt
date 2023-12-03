import kotlin.math.max

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
  fun printTree(root: TreeNode?): List<List<String>> {
    val h = height(root)
    val m = h + 1
    val n = (1 shl h + 1) - 1
    val res = Array(m) { arrayOfNulls<String>(n) }
    for (i in 0 until m) {
      Arrays.fill(res[i], "")
    }
    dfs(root, res, h, 0, (n - 1) / 2)
    val ans: List<List<String>> = ArrayList()
    for (t in res) {
      ans.add(Arrays.asList(t))
    }
    return ans
  }

  private fun dfs(root: TreeNode?, res: Array<Array<String?>>, h: Int, r: Int, c: Int) {
    if (root == null) {
      return
    }
    res[r][c] = java.lang.String.valueOf(root.`val`)
    dfs(root.left, res, h, r + 1, c - (1 shl h - r - 1))
    dfs(root.right, res, h, r + 1, c + (1 shl h - r - 1))
  }

  private fun height(root: TreeNode?): Int {
    return if (root == null) {
      -1
    } else (1 + max(height(root.left).toDouble(), height(root.right).toDouble())).toInt()
  }
}
