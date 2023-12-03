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
  fun kthLargestLevelSum(root: TreeNode, k: Int): Long {
    var root: TreeNode = root
    val arr: List<Long> = ArrayList()
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    while (!q.isEmpty()) {
      var t: Long = 0
      for (n in q.size() downTo 1) {
        root = q.pollFirst()
        t += root.`val`
        if (root.left != null) {
          q.offer(root.left)
        }
        if (root.right != null) {
          q.offer(root.right)
        }
      }
      arr.add(t)
    }
    if (arr.size() < k) {
      return -1
    }
    Collections.sort(arr, Collections.reverseOrder())
    return arr[k - 1]
  }
}
