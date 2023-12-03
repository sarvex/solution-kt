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
  fun findNearestRightNode(root: TreeNode, u: TreeNode): TreeNode? {
    var root: TreeNode = root
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    while (!q.isEmpty()) {
      for (i in q.size() downTo 1) {
        root = q.pollFirst()
        if (root === u) {
          return if (i > 1) q.peekFirst() else null
        }
        if (root.left != null) {
          q.offer(root.left)
        }
        if (root.right != null) {
          q.offer(root.right)
        }
      }
    }
    return null
  }
}
