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
  private val vis: Set<TreeNode> = HashSet()
  fun correctBinaryTree(root: TreeNode?): TreeNode? {
    return dfs(root)
  }

  private fun dfs(root: TreeNode?): TreeNode? {
    if (root == null || vis.contains(root.right)) {
      return null
    }
    vis.add(root)
    root.right = dfs(root.right)
    root.left = dfs(root.left)
    return root
  }
}
