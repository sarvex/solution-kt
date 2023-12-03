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
  fun sufficientSubset(root: TreeNode?, limit: Int): TreeNode? {
    var limit = limit
    if (root == null) {
      return null
    }
    limit -= root.`val`
    if (root.left == null && root.right == null) {
      return if (limit > 0) null else root
    }
    root.left = sufficientSubset(root.left, limit)
    root.right = sufficientSubset(root.right, limit)
    return if (root.left == null && root.right == null) null else root
  }
}
