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
  private var counter: Map<String, Int>? = null
  private var ans: List<TreeNode>? = null
  fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode>? {
    counter = HashMap()
    ans = ArrayList()
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): String {
    if (root == null) {
      return "#"
    }
    val v: String = root.`val` + "," + dfs(root.left) + "," + dfs(root.right)
    counter.put(v, (counter!![v] ?: 0) + 1)
    if (counter!![v] === 2) {
      ans.add(root)
    }
    return v
  }
}
