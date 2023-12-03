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
  fun convertBST(root: TreeNode?): TreeNode? {
    var root: TreeNode? = root
    var s = 0
    val node: TreeNode? = root
    while (root != null) {
      if (root.right == null) {
        s += root.`val`
        root.`val` = s
        root = root.left
      } else {
        var next: TreeNode = root.right
        while (next.left != null && next.left !== root) {
          next = next.left
        }
        if (next.left == null) {
          next.left = root
          root = root.right
        } else {
          s += root.`val`
          root.`val` = s
          next.left = null
          root = root.left
        }
      }
    }
    return node
  }
}
