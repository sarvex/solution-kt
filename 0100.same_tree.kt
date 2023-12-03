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
  fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p === q) return true
    return if (p == null || q == null || p.`val` !== q.`val`) false else isSameTree(
      p.left,
      q.left
    ) && isSameTree(p.right, q.right)
  }
}
