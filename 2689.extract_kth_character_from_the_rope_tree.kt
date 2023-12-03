/**
 * Definition for a rope tree node.
 * class RopeTreeNode {
 * int len;
 * String val;
 * RopeTreeNode left;
 * RopeTreeNode right;
 * RopeTreeNode() {}
 * RopeTreeNode(String val) {
 * this.len = 0;
 * this.val = val;
 * }
 * RopeTreeNode(int len) {
 * this.len = len;
 * this.val = "";
 * }
 * RopeTreeNode(int len, TreeNode left, TreeNode right) {
 * this.len = len;
 * this.val = "";
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
internal class Solution {
  fun getKthCharacter(root: RopeTreeNode?, k: Int): Char {
    return dfs(root)[k - 1]
  }

  private fun dfs(root: RopeTreeNode?): String {
    if (root == null) {
      return ""
    }
    if (root.`val`.length() > 0) {
      return root.`val`
    }
    val left = dfs(root.left)
    val right = dfs(root.right)
    return left + right
  }
}
