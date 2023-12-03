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
  fun insertIntoMaxTree(root: TreeNode, `val`: Int): TreeNode {
    if (root == null || root.`val` < `val`) {
      return TreeNode(`val`, root, null)
    }
    root.right = insertIntoMaxTree(root.right, `val`)
    return root
  }
}
