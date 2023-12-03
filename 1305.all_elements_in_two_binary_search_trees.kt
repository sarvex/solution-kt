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
  fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
    val t1: List<Int> = ArrayList()
    val t2: List<Int> = ArrayList()
    dfs(root1, t1)
    dfs(root2, t2)
    return merge(t1, t2)
  }

  private fun dfs(root: TreeNode?, t: List<Int>) {
    if (root == null) {
      return
    }
    dfs(root.left, t)
    t.add(root.`val`)
    dfs(root.right, t)
  }

  private fun merge(t1: List<Int>, t2: List<Int>): List<Int> {
    val ans: List<Int> = ArrayList()
    var i = 0
    var j = 0
    while (i < t1.size() && j < t2.size()) {
      if (t1[i] <= t2[j]) {
        ans.add(t1[i++])
      } else {
        ans.add(t2[j++])
      }
    }
    while (i < t1.size()) {
      ans.add(t1[i++])
    }
    while (j < t2.size()) {
      ans.add(t2[j++])
    }
    return ans
  }
}
