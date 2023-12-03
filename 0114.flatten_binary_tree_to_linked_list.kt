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
  fun flatten(root: TreeNode?) {
    var root: TreeNode? = root
    while (root != null) {
      if (root.left != null) {
        var pre: TreeNode = root.left
        while (pre.right != null) {
          pre = pre.right
        }
        pre.right = root.right
        root.right = root.left
        root.left = null
      }
      root = root.right
    }
  }
}
