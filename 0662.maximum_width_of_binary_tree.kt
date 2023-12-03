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
  fun widthOfBinaryTree(root: TreeNode): Int {
    var root: TreeNode = root
    val q: Deque<Pair<TreeNode, Int>> = ArrayDeque()
    q.offer(Pair(root, 1))
    var ans = 0
    while (!q.isEmpty()) {
      ans = Math.max(ans, q.peekLast().getValue() - q.peekFirst().getValue() + 1)
      for (n in q.size() downTo 1) {
        val p: Unit = q.pollFirst()
        root = p.getKey()
        val i: Int = p.getValue()
        if (root.left != null) {
          q.offer(Pair(root.left, i shl 1))
        }
        if (root.right != null) {
          q.offer(Pair(root.right, i shl 1 or 1))
        }
      }
    }
    return ans
  }
}
