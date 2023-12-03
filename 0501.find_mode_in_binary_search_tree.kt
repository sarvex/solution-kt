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
  private var mx = 0
  private var cnt = 0
  private var prev: TreeNode? = null
  private var res: List<Int>? = null
  fun findMode(root: TreeNode?): IntArray {
    res = ArrayList()
    dfs(root)
    val ans = IntArray(res.size())
    for (i in 0 until res.size()) {
      ans[i] = res.get(i)
    }
    return ans
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    dfs(root.left)
    cnt = if (prev != null && prev.`val` === root.`val`) cnt + 1 else 1
    if (cnt > mx) {
      res = ArrayList(Arrays.asList(root.`val`))
      mx = cnt
    } else if (cnt == mx) {
      res.add(root.`val`)
    }
    prev = root
    dfs(root.right)
  }
}
