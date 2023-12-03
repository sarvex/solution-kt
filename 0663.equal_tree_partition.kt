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
  private var seen: List<Int>? = null
  fun checkEqualTree(root: TreeNode?): Boolean {
    seen = ArrayList()
    val s = sum(root)
    if (s % 2 != 0) {
      return false
    }
    seen.remove(seen.size() - 1)
    return seen.contains(s / 2)
  }

  private fun sum(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val l = sum(root.left)
    val r = sum(root.right)
    val s: Int = l + r + root.`val`
    seen.add(s)
    return s
  }
}
