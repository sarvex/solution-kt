/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
internal class Solution {
  fun sumOfLeftLeaves(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    var res = 0
    if (root.left != null && root.left.left == null && root.left.right == null) {
      res += root.left.`val`
    }
    res += sumOfLeftLeaves(root.left)
    res += sumOfLeftLeaves(root.right)
    return res
  }
}
