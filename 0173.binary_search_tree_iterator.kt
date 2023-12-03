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
internal class BSTIterator(root: TreeNode?) {
  private val stack: Deque<TreeNode> = LinkedList()

  init {
    var root: TreeNode? = root
    while (root != null) {
      stack.offerLast(root)
      root = root.left
    }
  }

  operator fun next(): Int {
    val cur: TreeNode = stack.pollLast()
    var node: TreeNode = cur.right
    while (node != null) {
      stack.offerLast(node)
      node = node.left
    }
    return cur.`val`
  }

  operator fun hasNext(): Boolean {
    return !stack.isEmpty()
  }
}
