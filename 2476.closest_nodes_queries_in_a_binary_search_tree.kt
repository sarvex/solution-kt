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
  private val nums: List<Int> = ArrayList()
  fun closestNodes(root: TreeNode?, queries: List<Int>): List<List<Int>> {
    dfs(root)
    val ans: List<List<Int>> = ArrayList()
    for (v in queries) {
      val i = search(v + 1) - 1
      val j = search(v)
      val mi = if (i >= 0 && i < nums.size()) nums[i] else -1
      val mx = if (j >= 0 && j < nums.size()) nums[j] else -1
      ans.add(Arrays.asList(mi, mx))
    }
    return ans
  }

  private fun search(x: Int): Int {
    var left = 0
    var right: Int = nums.size()
    while (left < right) {
      val mid = left + right shr 1
      if (nums[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    dfs(root.left)
    nums.add(root.`val`)
    dfs(root.right)
  }
}
