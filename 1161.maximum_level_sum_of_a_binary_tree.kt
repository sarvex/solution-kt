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
  fun maxLevelSum(root: TreeNode): Int {
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    var mx = Int.MIN_VALUE
    var i = 0
    var ans = 0
    while (!q.isEmpty()) {
      ++i
      var s = 0
      for (n in q.size() downTo 1) {
        val node: TreeNode = q.pollFirst()
        s += node.`val`
        if (node.left != null) {
          q.offer(node.left)
        }
        if (node.right != null) {
          q.offer(node.right)
        }
      }
      if (mx < s) {
        mx = s
        ans = i
      }
    }
    return ans
  }
}
