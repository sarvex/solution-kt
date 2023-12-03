import java.util.*
import kotlin.collections.ArrayDeque

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
  fun isEvenOddTree(root: TreeNode): Boolean {
    var root: TreeNode = root
    var even = true
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    while (!q.isEmpty()) {
      var prev = if (even) 0 else 1000000
      for (n in q.size() downTo 1) {
        root = q.pollFirst()
        if (even && (root.`val` % 2 === 0 || prev >= root.`val`)) {
          return false
        }
        if (!even && (root.`val` % 2 === 1 || prev <= root.`val`)) {
          return false
        }
        prev = root.`val`
        if (root.left != null) {
          q.offer(root.left)
        }
        if (root.right != null) {
          q.offer(root.right)
        }
      }
      even = !even
    }
    return true
  }
}
