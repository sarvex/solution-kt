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
  private var edges: Map<Int, List<List<String>>>? = null
  private var visited: Set<Int>? = null
  private var ans: String? = null
  fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String? {
    edges = HashMap()
    visited = HashSet()
    ans = null
    traverse(root)
    dfs(startValue, destValue, ArrayList())
    return ans
  }

  private fun traverse(root: TreeNode?) {
    if (root == null) {
      return
    }
    if (root.left != null) {
      edges.computeIfAbsent(root.`val`) { k -> ArrayList() }
        .add(Arrays.asList(java.lang.String.valueOf(root.left.`val`), "L"))
      edges.computeIfAbsent(root.left.`val`) { k -> ArrayList() }
        .add(Arrays.asList(java.lang.String.valueOf(root.`val`), "U"))
    }
    if (root.right != null) {
      edges.computeIfAbsent(root.`val`) { k -> ArrayList() }
        .add(Arrays.asList(java.lang.String.valueOf(root.right.`val`), "R"))
      edges.computeIfAbsent(root.right.`val`) { k -> ArrayList() }
        .add(Arrays.asList(java.lang.String.valueOf(root.`val`), "U"))
    }
    traverse(root.left)
    traverse(root.right)
  }

  private fun dfs(start: Int, dest: Int, t: List<String>) {
    if (visited!!.contains(start)) {
      return
    }
    if (start == dest) {
      if (ans == null || ans!!.length > t.size()) {
        ans = java.lang.String.join("", t)
      }
      return
    }
    visited.add(start)
    if (edges!!.containsKey(start)) {
      for (item in edges!![start]!!) {
        t.add(item[1])
        dfs(item[0].toInt(), dest, t)
        t.remove(t.size() - 1)
      }
    }
  }
}
