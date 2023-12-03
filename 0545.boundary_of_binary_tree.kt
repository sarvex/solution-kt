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
  private var res: List<Int>? = null
  fun boundaryOfBinaryTree(root: TreeNode?): List<Int> {
    if (root == null) {
      return Collections.emptyList()
    }
    res = ArrayList()

    // root
    if (!isLeaf(root)) {
      res.add(root.`val`)
    }

    // left boundary
    var t: TreeNode = root.left
    while (t != null) {
      if (!isLeaf(t)) {
        res.add(t.`val`)
      }
      t = if (t.left == null) t.right else t.left
    }

    // leaves
    addLeaves(root)

    // right boundary(reverse order)
    val s: Deque<Int> = ArrayDeque()
    t = root.right
    while (t != null) {
      if (!isLeaf(t)) {
        s.offer(t.`val`)
      }
      t = if (t.right == null) t.left else t.right
    }
    while (!s.isEmpty()) {
      res.add(s.pollLast())
    }

    // output
    return res
  }

  private fun addLeaves(root: TreeNode?) {
    if (isLeaf(root)) {
      res.add(root.`val`)
      return
    }
    if (root.left != null) {
      addLeaves(root.left)
    }
    if (root.right != null) {
      addLeaves(root.right)
    }
  }

  private fun isLeaf(node: TreeNode?): Boolean {
    return node != null && node.left == null && node.right == null
  }
}
