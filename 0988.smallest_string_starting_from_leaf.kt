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
  private var path: StringBuilder? = null
  private var ans: String? = null
  fun smallestFromLeaf(root: TreeNode?): String {
    path = StringBuilder()
    ans = ('z'.code + 1).toChar().toString()
    dfs(root, path!!)
    return ans!!
  }

  private fun dfs(root: TreeNode?, path: StringBuilder) {
    if (root != null) {
      path.append(('a' + root.`val`))
      if (root.left == null && root.right == null) {
        val t = path.reverse().toString()
        if (t.compareTo(ans!!) < 0) {
          ans = t
        }
        path.reverse()
      }
      dfs(root.left, path)
      dfs(root.right, path)
      path.deleteCharAt(path.length - 1)
    }
  }
}
