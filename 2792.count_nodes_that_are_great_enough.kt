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
  private var ans = 0
  private var k = 0
  fun countGreatEnoughNodes(root: TreeNode?, k: Int): Int {
    this.k = k
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): PriorityQueue<Int> {
    if (root == null) {
      return PriorityQueue(Comparator.reverseOrder())
    }
    val l: PriorityQueue<Int> = dfs(root.left)
    val r: PriorityQueue<Int> = dfs(root.right)
    for (x in r) {
      l.offer(x)
      if (l.size() > k) {
        l.poll()
      }
    }
    if (l.size() === k && l.peek() < root.`val`) {
      ++ans
    }
    l.offer(root.`val`)
    if (l.size() > k) {
      l.poll()
    }
    return l
  }
}
