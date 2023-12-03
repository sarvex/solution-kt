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
  private var counter: Map<Int, Int>? = null
  private var mx = 0
  fun findFrequentTreeSum(root: TreeNode?): IntArray {
    counter = HashMap()
    mx = Int.MIN_VALUE
    dfs(root)
    val res: List<Int> = ArrayList()
    for (entry in counter.entrySet()) {
      if (entry.getValue() === mx) {
        res.add(entry.getKey())
      }
    }
    val ans = IntArray(res.size())
    for (i in 0 until res.size()) {
      ans[i] = res[i]
    }
    return ans
  }

  private fun dfs(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val s: Int = root.`val` + dfs(root.left) + dfs(root.right)
    counter.put(s, (counter!![s] ?: 0) + 1)
    mx = Math.max(mx, counter!![s]!!)
    return s
  }
}
