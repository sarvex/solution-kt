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
  fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    var root: TreeNode = root ?: return null
    if (root.`val` > key) {
      root.left = deleteNode(root.left, key)
      return root
    }
    if (root.`val` < key) {
      root.right = deleteNode(root.right, key)
      return root
    }
    if (root.left == null) {
      return root.right
    }
    if (root.right == null) {
      return root.left
    }
    var node: TreeNode = root.right
    while (node.left != null) {
      node = node.left
    }
    node.left = root.left
    root = root.right
    return root
  }
}
