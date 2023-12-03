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
  fun insertIntoBST(root: TreeNode, `val`: Int): TreeNode {
    if (root == null) {
      return TreeNode(`val`)
    }
    if (root.`val` < `val`) {
      root.right = insertIntoBST(root.right, `val`)
    } else {
      root.left = insertIntoBST(root.left, `val`)
    }
    return root
  }
}
