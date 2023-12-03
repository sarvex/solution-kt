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
  fun findBottomLeftValue(root: TreeNode?): Int {
    val q: Queue<TreeNode> = ArrayDeque()
    q.offer(root)
    var ans = 0
    while (!q.isEmpty()) {
      ans = q.peek().`val`
      for (i in q.size() downTo 1) {
        val node: TreeNode = q.poll()
        if (node.left != null) {
          q.offer(node.left)
        }
        if (node.right != null) {
          q.offer(node.right)
        }
      }
    }
    return ans
  }
}
