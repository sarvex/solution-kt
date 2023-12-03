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
  private var i = 0
  private var ok = false
  private var voyage: IntArray
  private val ans: List<Int> = ArrayList()
  fun flipMatchVoyage(root: TreeNode?, voyage: IntArray): List<Int> {
    this.voyage = voyage
    ok = true
    dfs(root)
    return if (ok) ans else List.of(-1)
  }

  private fun dfs(root: TreeNode?) {
    if (root == null || !ok) {
      return
    }
    if (root.`val` !== voyage[i]) {
      ok = false
      return
    }
    ++i
    if (root.left == null || root.left.`val` === voyage[i]) {
      dfs(root.left)
      dfs(root.right)
    } else {
      ans.add(root.`val`)
      dfs(root.right)
      dfs(root.left)
    }
  }
}
