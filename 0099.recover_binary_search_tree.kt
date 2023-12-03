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
  private var prev: TreeNode? = null
  private var first: TreeNode? = null
  private var second: TreeNode? = null
  fun recoverTree(root: TreeNode?) {
    dfs(root)
    val t: Int = first.`val`
    first.`val` = second.`val`
    second.`val` = t
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    dfs(root.left)
    if (prev != null && prev.`val` > root.`val`) {
      if (first == null) {
        first = prev
      }
      second = root
    }
    prev = root
    dfs(root.right)
  }
}
