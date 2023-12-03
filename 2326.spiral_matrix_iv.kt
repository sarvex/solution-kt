/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
internal class Solution {
  fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
    var head: ListNode? = head
    val ans = Array(m) { IntArray(n) }
    for (row in ans) {
      Arrays.fill(row, -1)
    }
    var i = 0
    var j = 0
    var p = 0
    val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
    while (true) {
      ans[i][j] = head.`val`
      head = head.next
      if (head == null) {
        break
      }
      while (true) {
        val x = i + dirs[p][0]
        val y = j + dirs[p][1]
        if (x < 0 || y < 0 || x >= m || y >= n || ans[x][y] >= 0) {
          p = (p + 1) % 4
        } else {
          i = x
          j = y
          break
        }
      }
    }
    return ans
  }
}
