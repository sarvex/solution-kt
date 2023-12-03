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
  fun postorderTraversal(root: TreeNode?): List<Int> {
    var root: TreeNode? = root
    val ans: LinkedList<Int> = LinkedList()
    while (root != null) {
      if (root.right == null) {
        ans.addFirst(root.`val`)
        root = root.left
      } else {
        var next: TreeNode = root.right
        while (next.left != null && next.left !== root) {
          next = next.left
        }
        if (next.left == null) {
          ans.addFirst(root.`val`)
          next.left = root
          root = root.right
        } else {
          next.left = null
          root = root.left
        }
      }
    }
    return ans
  }
}
