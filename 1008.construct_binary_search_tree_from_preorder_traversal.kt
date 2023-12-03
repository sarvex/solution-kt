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
  fun bstFromPreorder(preorder: IntArray): TreeNode? {
    return dfs(preorder, 0, preorder.size - 1)
  }

  private fun dfs(preorder: IntArray, i: Int, j: Int): TreeNode? {
    if (i > j || i >= preorder.size) {
      return null
    }
    val root = TreeNode(preorder[i])
    var left = i + 1
    var right = j + 1
    while (left < right) {
      val mid = left + right shr 1
      if (preorder[mid] > preorder[i]) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    root.left = dfs(preorder, i + 1, left - 1)
    root.right = dfs(preorder, left, j)
    return root
  }
}
