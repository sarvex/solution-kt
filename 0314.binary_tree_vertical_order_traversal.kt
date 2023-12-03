import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

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
  fun verticalOrder(root: TreeNode?): List<List<Int>> {
    var root: TreeNode? = root
    val ans: List<List<Int>> = ArrayList()
    if (root == null) {
      return ans
    }
    val q: Deque<Pair<TreeNode, Int>> = ArrayDeque()
    q.offer(Pair(root, 0))
    val d: TreeMap<Int, List<Int>> = TreeMap()
    while (!q.isEmpty()) {
      for (n in q.size() downTo 1) {
        val p: Unit = q.pollFirst()
        root = p.getKey()
        val offset: Int = p.getValue()
        d.computeIfAbsent(offset) { k -> ArrayList() }.add(root.`val`)
        if (root.left != null) {
          q.offer(Pair(root.left, offset - 1))
        }
        if (root.right != null) {
          q.offer(Pair(root.right, offset + 1))
        }
      }
    }
    return ArrayList(d.values())
  }
}
