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
  fun deepestLeavesSum(root: TreeNode): Int {
    var root: TreeNode = root
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    var ans = 0
    while (!q.isEmpty()) {
      ans = 0
      for (n in q.size() downTo 1) {
        root = q.pollFirst()
        ans += root.`val`
        if (root.left != null) {
          q.offer(root.left)
        }
        if (root.right != null) {
          q.offer(root.right)
        }
      }
    }
    return ans
  }
}
