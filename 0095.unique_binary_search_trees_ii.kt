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
  fun generateTrees(n: Int): List<TreeNode> {
    return generateTrees(1, n)
  }

  private fun generateTrees(left: Int, right: Int): List<TreeNode> {
    val ans: List<TreeNode> = ArrayList()
    if (left > right) {
      ans.add(null)
    } else {
      for (i in left..right) {
        val leftTrees: List<TreeNode> = generateTrees(left, i - 1)
        val rightTrees: List<TreeNode> = generateTrees(i + 1, right)
        for (l in leftTrees) {
          for (r in rightTrees) {
            val node = TreeNode(i, l, r)
            ans.add(node)
          }
        }
      }
    }
    return ans
  }
}
