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
  private val ans: List<String> = ArrayList()
  private val t: List<String> = ArrayList()
  fun binaryTreePaths(root: TreeNode?): List<String> {
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    t.add(root.`val` + "")
    if (root.left == null && root.right == null) {
      ans.add(java.lang.String.join("->", t))
    } else {
      dfs(root.left)
      dfs(root.right)
    }
    t.remove(t.size() - 1)
  }
}
