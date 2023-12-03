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
  fun isCompleteTree(root: TreeNode?): Boolean {
    val q: Deque<TreeNode> = LinkedList()
    q.offer(root)
    while (q.peek() != null) {
      val node: TreeNode = q.poll()
      q.offer(node.left)
      q.offer(node.right)
    }
    while (!q.isEmpty() && q.peek() == null) {
      q.poll()
    }
    return q.isEmpty()
  }
}
