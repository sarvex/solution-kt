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
  private var nums: IntArray
  fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    this.nums = nums
    return dfs(0, nums.size - 1)
  }

  private fun dfs(l: Int, r: Int): TreeNode? {
    if (l > r) {
      return null
    }
    var i = l
    for (j in l..r) {
      if (nums[i] < nums[j]) {
        i = j
      }
    }
    val root = TreeNode(nums[i])
    root.left = dfs(l, i - 1)
    root.right = dfs(i + 1, r)
    return root
  }
}
