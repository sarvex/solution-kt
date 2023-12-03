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
  fun pruneTree(root: TreeNode?): TreeNode? {
    if (root == null) {
      return null
    }
    root.left = pruneTree(root.left)
    root.right = pruneTree(root.right)
    return if (root.`val` === 0 && root.left == null && root.right == null) {
      null
    } else root
  }
}
