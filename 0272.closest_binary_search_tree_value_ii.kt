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
  private var ans: List<Int>? = null
  private var target = 0.0
  private var k = 0
  fun closestKValues(root: TreeNode?, target: Double, k: Int): List<Int>? {
    ans = LinkedList()
    this.target = target
    this.k = k
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    dfs(root.left)
    if (ans!!.size() < k) {
      ans.add(root.`val`)
    } else {
      if (Math.abs(root.`val` - target) >= Math.abs(ans!![0] - target)) {
        return
      }
      ans.remove(0)
      ans.add(root.`val`)
    }
    dfs(root.right)
  }
}
