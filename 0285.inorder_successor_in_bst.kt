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
  fun inorderSuccessor(root: TreeNode?, p: TreeNode): TreeNode? {
    var root: TreeNode? = root
    var ans: TreeNode? = null
    while (root != null) {
      if (root.`val` > p.`val`) {
        ans = root
        root = root.left
      } else {
        root = root.right
      }
    }
    return ans
  }
}
