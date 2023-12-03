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
  fun closestValue(root: TreeNode?, target: Double): Int {
    var root: TreeNode? = root
    var ans: Int = root.`val`
    var mi = Double.MAX_VALUE
    while (root != null) {
      val t: Double = Math.abs(root.`val` - target)
      if (t < mi || t == mi && root.`val` < ans) {
        mi = t
        ans = root.`val`
      }
      root = if (root.`val` > target) {
        root.left
      } else {
        root.right
      }
    }
    return ans
  }
}
