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
  private val ans: List<Int> = ArrayList()
  fun getLonelyNodes(root: TreeNode?): List<Int> {
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?) {
    if (root == null || root.left == null && root.right == null) {
      return
    }
    if (root.left == null) {
      ans.add(root.right.`val`)
    }
    if (root.right == null) {
      ans.add(root.left.`val`)
    }
    dfs(root.left)
    dfs(root.right)
  }
}
