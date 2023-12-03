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
  private val nums: Array<List<Int>?> = arrayOfNulls(2)
  fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
    Arrays.setAll(nums) { k -> ArrayList() }
    dfs(root1, 0)
    dfs(root2, 1)
    var i = 0
    var j: Int = nums[1]!!.size() - 1
    while (i < nums[0]!!.size() && j >= 0) {
      val x = nums[0]!![i] + nums[1]!![j]
      if (x == target) {
        return true
      }
      if (x < target) {
        ++i
      } else {
        --j
      }
    }
    return false
  }

  private fun dfs(root: TreeNode?, i: Int) {
    if (root == null) {
      return
    }
    dfs(root.left, i)
    nums[i].add(root.`val`)
    dfs(root.right, i)
  }
}
