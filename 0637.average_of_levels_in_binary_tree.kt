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
  fun averageOfLevels(root: TreeNode): List<Double> {
    var root: TreeNode = root
    val ans: List<Double> = ArrayList()
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    while (!q.isEmpty()) {
      val n: Int = q.size()
      var s: Long = 0
      for (i in 0 until n) {
        root = q.pollFirst()
        s += root.`val`
        if (root.left != null) {
          q.offer(root.left)
        }
        if (root.right != null) {
          q.offer(root.right)
        }
      }
      ans.add(s * 1.0 / n)
    }
    return ans
  }
}
