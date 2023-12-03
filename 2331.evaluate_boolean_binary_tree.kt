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
  fun evaluateTree(root: TreeNode): Boolean {
    if (root.left == null) {
      return root.`val` === 1
    }
    val l = evaluateTree(root.left)
    val r = evaluateTree(root.right)
    return if (root.`val` === 2) l || r else l && r
  }
}
