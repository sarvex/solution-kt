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
  fun minimumOperations(root: TreeNode?): Int {
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    var ans = 0
    while (!q.isEmpty()) {
      val t: List<Int> = ArrayList()
      for (n in q.size() downTo 1) {
        val node: TreeNode = q.poll()
        t.add(node.`val`)
        if (node.left != null) {
          q.offer(node.left)
        }
        if (node.right != null) {
          q.offer(node.right)
        }
      }
      ans += f(t)
    }
    return ans
  }

  private fun f(t: List<Int>): Int {
    val n: Int = t.size()
    val alls: List<Int> = ArrayList(t)
    alls.sort { a, b -> a - b }
    val m: Map<Int, Int> = HashMap()
    for (i in 0 until n) {
      m.put(alls[i], i)
    }
    val arr = IntArray(n)
    for (i in 0 until n) {
      arr[i] = m[t[i]]!!
    }
    var ans = 0
    for (i in 0 until n) {
      while (arr[i] != i) {
        swap(arr, i, arr[i])
        ++ans
      }
    }
    return ans
  }

  private fun swap(arr: IntArray, i: Int, j: Int) {
    val t = arr[i]
    arr[i] = arr[j]
    arr[j] = t
  }
}
