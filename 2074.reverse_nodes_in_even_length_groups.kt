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
  fun reverseEvenLengthGroups(head: ListNode?): ListNode {
    var n = 0
    var t: ListNode? = head
    while (t != null) {
      ++n
      t = t.next
    }
    val dummy = ListNode(0, head)
    var prev: ListNode = dummy
    var l = 1
    while ((1 + l) * l / 2 <= n && prev != null) {
      if (l % 2 == 0) {
        val node: ListNode = prev.next
        prev.next = reverse(node, l)
      }
      var i = 0
      while (i < l && prev != null) {
        prev = prev.next
        ++i
      }
      ++l
    }
    val left = n - l * (l - 1) / 2
    if (left > 0 && left % 2 == 0) {
      val node: ListNode = prev.next
      prev.next = reverse(node, left)
    }
    return dummy.next
  }

  private fun reverse(head: ListNode, l: Int): ListNode? {
    var prev: ListNode? = null
    var cur: ListNode = head
    val tail: ListNode = cur
    var i = 0
    while (cur != null && i < l) {
      val t: ListNode = cur.next
      cur.next = prev
      prev = cur
      cur = t
      ++i
    }
    tail.next = cur
    return prev
  }
}
