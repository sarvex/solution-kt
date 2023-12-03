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
  private val s = BooleanArray(1001)
  private val ans: List<TreeNode> = ArrayList()
  fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode> {
    for (x in to_delete) {
      s[x] = true
    }
    if (dfs(root) != null) {
      ans.add(root)
    }
    return ans
  }

  private fun dfs(root: TreeNode?): TreeNode? {
    if (root == null) {
      return null
    }
    root.left = dfs(root.left)
    root.right = dfs(root.right)
    if (!s[root.`val`]) {
      return root
    }
    if (root.left != null) {
      ans.add(root.left)
    }
    if (root.right != null) {
      ans.add(root.right)
    }
    return null
  }
}
