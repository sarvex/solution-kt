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
  private val indexes: Map<Int, Int> = HashMap()
  fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    for (i in inorder.indices) {
      indexes.put(inorder[i], i)
    }
    return dfs(inorder, postorder, 0, 0, inorder.size)
  }

  private fun dfs(inorder: IntArray, postorder: IntArray, i: Int, j: Int, n: Int): TreeNode? {
    if (n <= 0) {
      return null
    }
    val v = postorder[j + n - 1]
    val k = indexes[v]!!
    val root = TreeNode(v)
    root.left = dfs(inorder, postorder, i, j, k - i)
    root.right = dfs(inorder, postorder, k + 1, j + k - i, n - k + i - 1)
    return root
  }
}
