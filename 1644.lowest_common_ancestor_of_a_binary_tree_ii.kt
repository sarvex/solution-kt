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
  private var ans: TreeNode? = null
  fun lowestCommonAncestor(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
    dfs(root, p, q)
    return ans
  }

  private fun dfs(root: TreeNode?, p: TreeNode, q: TreeNode): Boolean {
    if (root == null) {
      return false
    }
    val l = dfs(root.left, p, q)
    val r = dfs(root.right, p, q)
    if (l && r) {
      ans = root
    }
    if ((l || r) && (root.`val` === p.`val` || root.`val` === q.`val`)) {
      ans = root
    }
    return l || r || root.`val` === p.`val` || root.`val` === q.`val`
  }
}
