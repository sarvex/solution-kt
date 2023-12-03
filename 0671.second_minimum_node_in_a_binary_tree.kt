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
  private var ans = -1
  fun findSecondMinimumValue(root: TreeNode): Int {
    dfs(root, root.`val`)
    return ans
  }

  private fun dfs(root: TreeNode?, `val`: Int) {
    if (root != null) {
      dfs(root.left, `val`)
      dfs(root.right, `val`)
      if (root.`val` > `val`) {
        ans = if (ans == -1) root.`val` else Math.min(ans, root.`val`)
      }
    }
  }
}
