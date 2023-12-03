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
  private val ans: List<List<Int>> = ArrayList()
  private val t: List<Int> = ArrayList()
  fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    dfs(root, targetSum)
    return ans
  }

  private fun dfs(root: TreeNode?, s: Int) {
    var s = s
    if (root == null) {
      return
    }
    s -= root.`val`
    t.add(root.`val`)
    if (root.left == null && root.right == null && s == 0) {
      ans.add(ArrayList(t))
    }
    dfs(root.left, s)
    dfs(root.right, s)
    t.remove(t.size() - 1)
  }
}
