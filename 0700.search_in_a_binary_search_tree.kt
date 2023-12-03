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
  fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null || root.`val` === `val`) {
      return root
    }
    return if (root.`val` < `val`) searchBST(root.right, `val`) else searchBST(root.left, `val`)
  }
}
