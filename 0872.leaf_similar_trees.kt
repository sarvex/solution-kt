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
  fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val l1 = dfs(root1)
    val l2 = dfs(root2)
    return l1.equals(l2)
  }

  private fun dfs(root: TreeNode?): List<Int> {
    if (root == null) {
      return ArrayList()
    }
    val ans = dfs(root.left)
    ans.addAll(dfs(root.right))
    if (ans.isEmpty()) {
      ans.add(root.`val`)
    }
    return ans
  }
}
