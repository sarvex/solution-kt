/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
internal class Solution {
  private var target: TreeNode? = null
  fun getTargetCopy(
    original: TreeNode?, cloned: TreeNode, target: TreeNode?
  ): TreeNode? {
    this.target = target
    return dfs(original, cloned)
  }

  private fun dfs(root1: TreeNode?, root2: TreeNode): TreeNode? {
    if (root1 == null) {
      return null
    }
    if (root1 === target) {
      return root2
    }
    val res: TreeNode? = dfs(root1.left, root2.left)
    return if (res == null) dfs(root1.right, root2.right) else res
  }
}
