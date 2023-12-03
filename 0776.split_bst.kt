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
  private var t = 0
  fun splitBST(root: TreeNode, target: Int): Array<TreeNode> {
    t = target
    return dfs(root)
  }

  private fun dfs(root: TreeNode): Array<TreeNode> {
    if (root == null) {
      return arrayOf(null, null)
    }
    return if (root.`val` <= t) {
      val ans: Array<TreeNode> = dfs(root.right)
      root.right = ans[0]
      ans[0] = root
      ans
    } else {
      val ans: Array<TreeNode> = dfs(root.left)
      root.left = ans[1]
      ans[1] = root
      ans
    }
  }
}
