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
  fun invertTree(root: TreeNode?): TreeNode? {
    dfs(root)
    return root
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    val t: TreeNode = root.left
    root.left = root.right
    root.right = t
    dfs(root.left)
    dfs(root.right)
  }
}
