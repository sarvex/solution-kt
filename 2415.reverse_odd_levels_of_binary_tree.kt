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
  fun reverseOddLevels(root: TreeNode): TreeNode {
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    var i = 0
    while (!q.isEmpty()) {
      val t: List<TreeNode> = ArrayList()
      for (n in q.size() downTo 1) {
        val node: TreeNode = q.pollFirst()
        if (i % 2 == 1) {
          t.add(node)
        }
        if (node.left != null) {
          q.offer(node.left)
        }
        if (node.right != null) {
          q.offer(node.right)
        }
      }
      if (!t.isEmpty()) {
        var j = 0
        var k: Int = t.size() - 1
        while (j < k) {
          val v: Int = t[j].`val`
          t[j].`val` = t[k].`val`
          t[k].`val` = v
          ++j
          --k
        }
      }
      ++i
    }
    return root
  }
}
