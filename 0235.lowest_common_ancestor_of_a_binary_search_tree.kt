/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
internal class Solution {
  fun lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode {
    var root: TreeNode = root
    while (true) {
      root = if (root.`val` < Math.min(p.`val`, q.`val`)) {
        root.right
      } else if (root.`val` > Math.max(p.`val`, q.`val`)) {
        root.left
      } else {
        return root
      }
    }
  }
}
