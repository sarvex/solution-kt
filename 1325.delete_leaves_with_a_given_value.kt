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
  fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
    if (root == null) {
      return null
    }
    root.left = removeLeafNodes(root.left, target)
    root.right = removeLeafNodes(root.right, target)
    return if (root.left == null && root.right == null && root.`val` === target) {
      null
    } else root
  }
}
