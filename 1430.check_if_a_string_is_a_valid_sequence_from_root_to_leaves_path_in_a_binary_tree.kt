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
  private var arr: IntArray
  fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
    this.arr = arr
    return dfs(root, 0)
  }

  private fun dfs(root: TreeNode?, u: Int): Boolean {
    if (root == null || root.`val` !== arr[u]) {
      return false
    }
    return if (u == arr.size - 1) {
      root.left == null && root.right == null
    } else dfs(root.left, u + 1) || dfs(root.right, u + 1)
  }
}
