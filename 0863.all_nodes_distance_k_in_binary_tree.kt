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
  private var p: Map<TreeNode, TreeNode>? = null
  private var vis: Set<Int>? = null
  private var ans: List<Int>? = null
  fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
    p = HashMap()
    vis = HashSet()
    ans = ArrayList()
    parents(root, null)
    dfs(target, k)
    return ans
  }

  private fun parents(root: TreeNode?, prev: TreeNode?) {
    if (root == null) {
      return
    }
    p.put(root, prev)
    parents(root.left, root)
    parents(root.right, root)
  }

  private fun dfs(root: TreeNode?, k: Int) {
    if (root == null || vis!!.contains(root.`val`)) {
      return
    }
    vis.add(root.`val`)
    if (k == 0) {
      ans.add(root.`val`)
      return
    }
    dfs(root.left, k - 1)
    dfs(root.right, k - 1)
    dfs(p!![root], k - 1)
  }
}
