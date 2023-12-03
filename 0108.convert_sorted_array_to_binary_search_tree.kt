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
  fun sortedArrayToBST(nums: IntArray): TreeNode? {
    this.nums = nums
    return dfs(0, nums.size - 1)
  }

  private fun dfs(l: Int, r: Int): TreeNode? {
    if (l > r) {
      return null
    }
    val mid = l + r shr 1
    val left: TreeNode? = dfs(l, mid - 1)
    val right: TreeNode? = dfs(mid + 1, r)
    return TreeNode(nums[mid], left, right)
  }
}
