import kotlin.math.min

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
  fun nodesBetweenCriticalPoints(head: ListNode): IntArray {
    var prev: ListNode = head
    var curr: ListNode = head.next
    var first = 0
    var last = 0
    var i = 1
    val ans = intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE)
    while (curr.next != null) {
      if (curr.`val` < Math.min(prev.`val`, curr.next.`val`)
        || curr.`val` > Math.max(prev.`val`, curr.next.`val`)
      ) {
        if (last == 0) {
          first = i
          last = i
        } else {
          ans[0] = min(ans[0].toDouble(), (i - last).toDouble()).toInt()
          ans[1] = i - first
          last = i
        }
      }
      ++i
      prev = curr
      curr = curr.next
    }
    return if (first == last) intArrayOf(-1, -1) else ans
  }
}
