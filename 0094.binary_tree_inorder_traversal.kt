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
  fun inorderTraversal(root: TreeNode?): List<Int> {
    var root: TreeNode? = root
    val ans: List<Int> = ArrayList()
    while (root != null) {
      if (root.left == null) {
        ans.add(root.`val`)
        root = root.right
      } else {
        var prev: TreeNode = root.left
        while (prev.right != null && prev.right !== root) {
          prev = prev.right
        }
        if (prev.right == null) {
          prev.right = root
          root = root.left
        } else {
          ans.add(root.`val`)
          prev.right = null
          root = root.right
        }
      }
    }
    return ans
  }
}
