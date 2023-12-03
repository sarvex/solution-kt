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
  private val d: Map<TreeNode, Int> = HashMap()
  private var res: IntArray
  fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {
    f(root)
    res = IntArray(d.size() + 1)
    d.put(null, 0)
    dfs(root, -1, 0)
    val m = queries.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      ans[i] = res[queries[i]]
    }
    return ans
  }

  private fun dfs(root: TreeNode?, depth: Int, rest: Int) {
    var depth = depth
    if (root == null) {
      return
    }
    ++depth
    res[root.`val`] = rest
    dfs(root.left, depth, Math.max(rest, depth + d[root.right]!!))
    dfs(root.right, depth, Math.max(rest, depth + d[root.left]!!))
  }

  private fun f(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val l = f(root.left)
    val r = f(root.right)
    d.put(root, 1 + max(l.toDouble(), r.toDouble()))
    return d[root]!!
  }
}
