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
  fun increasingBST(root: TreeNode?): TreeNode {
    val dummy = TreeNode(0, null, root)
    prev = dummy
    dfs(root)
    return dummy.right
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    dfs(root.left)
    prev.right = root
    root.left = null
    prev = root
    dfs(root.right)
  }
}
