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
  fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    val ans: LinkedList<List<Int>> = LinkedList()
    if (root == null) {
      return ans
    }
    val q: Deque<TreeNode> = LinkedList()
    q.offerLast(root)
    while (!q.isEmpty()) {
      val t: List<Int> = ArrayList()
      for (i in q.size() downTo 1) {
        val node: TreeNode = q.pollFirst()
        t.add(node.`val`)
        if (node.left != null) {
          q.offerLast(node.left)
        }
        if (node.right != null) {
          q.offerLast(node.right)
        }
      }
      ans.addFirst(t)
    }
    return ans
  }
}
