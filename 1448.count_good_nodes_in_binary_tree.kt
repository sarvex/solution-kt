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
  private var ans = 0
  fun goodNodes(root: TreeNode?): Int {
    dfs(root, -100000)
    return ans
  }

  private fun dfs(root: TreeNode?, mx: Int) {
    var mx = mx
    if (root == null) {
      return
    }
    if (mx <= root.`val`) {
      ++ans
      mx = root.`val`
    }
    dfs(root.left, mx)
    dfs(root.right, mx)
  }
}
