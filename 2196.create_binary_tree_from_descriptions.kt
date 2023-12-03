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
  fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
    val m: Map<Int, TreeNode> = HashMap()
    val vis: Set<Int> = HashSet()
    for (d in descriptions) {
      val p = d[0]
      val c = d[1]
      val isLeft = d[2]
      if (!m.containsKey(p)) {
        m.put(p, TreeNode(p))
      }
      if (!m.containsKey(c)) {
        m.put(c, TreeNode(c))
      }
      if (isLeft == 1) {
        m[p].left = m[c]
      } else {
        m[p].right = m[c]
      }
      vis.add(c)
    }
    for (entry in m.entrySet()) {
      if (!vis.contains(entry.getKey())) {
        return entry.getValue()
      }
    }
    return null
  }
}
