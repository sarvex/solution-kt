import kotlin.math.abs

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
  private var ans = 0
  fun findTilt(root: TreeNode?): Int {
    ans = 0
    sum(root)
    return ans
  }

  private fun sum(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val left = sum(root.left)
    val right = sum(root.right)
    (ans += abs((left - right).toDouble())).toInt()
    return root.`val` + left + right
  }
}
