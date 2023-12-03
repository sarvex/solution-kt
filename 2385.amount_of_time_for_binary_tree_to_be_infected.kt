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
  private val g: Map<Int, List<Int>> = HashMap()
  fun amountOfTime(root: TreeNode?, start: Int): Int {
    dfs(root)
    val q: Deque<Int> = ArrayDeque()
    val vis: Set<Int> = HashSet()
    q.offer(start)
    var ans = -1
    while (!q.isEmpty()) {
      ++ans
      for (n in q.size() downTo 1) {
        val i: Int = q.pollFirst()
        vis.add(i)
        if (g.containsKey(i)) {
          for (j in g[i]!!) {
            if (!vis.contains(j)) {
              q.offer(j)
            }
          }
        }
      }
    }
    return ans
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    if (root.left != null) {
      g.computeIfAbsent(root.`val`) { k -> ArrayList() }.add(root.left.`val`)
      g.computeIfAbsent(root.left.`val`) { k -> ArrayList() }.add(root.`val`)
    }
    if (root.right != null) {
      g.computeIfAbsent(root.`val`) { k -> ArrayList() }.add(root.right.`val`)
      g.computeIfAbsent(root.right.`val`) { k -> ArrayList() }.add(root.`val`)
    }
    dfs(root.left)
    dfs(root.right)
  }
}
