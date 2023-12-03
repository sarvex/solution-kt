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
  private var preorder: IntArray
  private val d: Map<Int, Int> = HashMap()
  fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val n = preorder.size
    this.preorder = preorder
    for (i in 0 until n) {
      d.put(inorder[i], i)
    }
    return dfs(0, 0, n)
  }

  private fun dfs(i: Int, j: Int, n: Int): TreeNode? {
    if (n <= 0) {
      return null
    }
    val v = preorder[i]
    val k = d[v]!!
    val l: TreeNode? = dfs(i + 1, j, k - j)
    val r: TreeNode? = dfs(i + 1 + k - j, k + 1, n - 1 - (k - j))
    return TreeNode(v, l, r)
  }
}
