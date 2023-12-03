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
  fun countPairs(root: TreeNode?, distance: Int): Int {
    if (root == null) {
      return 0
    }
    var ans = countPairs(root.left, distance) + countPairs(root.right, distance)
    val cnt1 = IntArray(distance)
    val cnt2 = IntArray(distance)
    dfs(root.left, cnt1, 1)
    dfs(root.right, cnt2, 1)
    for (i in 0 until distance) {
      for (j in 0 until distance) {
        if (i + j <= distance) {
          ans += cnt1[i] * cnt2[j]
        }
      }
    }
    return ans
  }

  fun dfs(root: TreeNode?, cnt: IntArray, i: Int) {
    if (root == null || i >= cnt.size) {
      return
    }
    if (root.left == null && root.right == null) {
      ++cnt[i]
      return
    }
    dfs(root.left, cnt, i + 1)
    dfs(root.right, cnt, i + 1)
  }
}
