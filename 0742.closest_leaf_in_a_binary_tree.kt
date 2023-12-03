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
  private var g: Map<TreeNode, List<TreeNode>>? = null
  fun findClosestLeaf(root: TreeNode?, k: Int): Int {
    g = HashMap()
    dfs(root, null)
    val q: Deque<TreeNode> = LinkedList()
    for (entry in g.entrySet()) {
      if (entry.getKey() != null && entry.getKey().`val` === k) {
        q.offer(entry.getKey())
        break
      }
    }
    val seen: Set<TreeNode> = HashSet()
    while (!q.isEmpty()) {
      val node: TreeNode = q.poll()
      seen.add(node)
      if (node != null) {
        if (node.left == null && node.right == null) {
          return node.`val`
        }
        for (next in g!![node]) {
          if (!seen.contains(next)) {
            q.offer(next)
          }
        }
      }
    }
    return 0
  }

  private fun dfs(root: TreeNode?, p: TreeNode?) {
    if (root != null) {
      g.computeIfAbsent(root) { k -> ArrayList() }.add(p)
      g.computeIfAbsent(p) { k -> ArrayList() }.add(root)
      dfs(root.left, root)
      dfs(root.right, root)
    }
  }
}
