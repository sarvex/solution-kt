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
  fun largestValues(root: TreeNode?): List<Int> {
    val ans: List<Int> = ArrayList()
    if (root == null) {
      return ans
    }
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    while (!q.isEmpty()) {
      var t: Int = q.peek().`val`
      for (i in q.size() downTo 1) {
        val node: TreeNode = q.poll()
        t = Math.max(t, node.`val`)
        if (node.left != null) {
          q.offer(node.left)
        }
        if (node.right != null) {
          q.offer(node.right)
        }
      }
      ans.add(t)
    }
    return ans
  }
}
