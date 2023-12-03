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
  fun str2tree(s: String): TreeNode? {
    return dfs(s)
  }

  private fun dfs(s: String): TreeNode? {
    if ("" == s) {
      return null
    }
    val p = s.indexOf("(")
    if (p == -1) {
      return TreeNode(s.toInt())
    }
    val root = TreeNode(s.substring(0, p).toInt())
    var start = p
    var cnt = 0
    for (i in p until s.length) {
      if (s[i] == '(') {
        ++cnt
      } else if (s[i] == ')') {
        --cnt
      }
      if (cnt == 0) {
        if (start == p) {
          root.left = dfs(s.substring(start + 1, i))
          start = i + 1
        } else {
          root.right = dfs(s.substring(start + 1, i))
        }
      }
    }
    return root
  }
}
