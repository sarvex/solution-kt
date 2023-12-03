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
internal class BSTIterator(root: TreeNode?) {
  private val nums: List<Int> = ArrayList()
  private var i = -1

  init {
    dfs(root)
  }

  operator fun hasNext(): Boolean {
    return i < nums.size() - 1
  }

  operator fun next(): Int {
    return nums[++i]
  }

  fun hasPrev(): Boolean {
    return i > 0
  }

  fun prev(): Int {
    return nums[--i]
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    dfs(root.left)
    nums.add(root.`val`)
    dfs(root.right)
  }
}
