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
  fun reverseKGroup(head: ListNode?, k: Int): ListNode {
    val dummy = ListNode(0, head)
    var pre: ListNode = dummy
    var cur: ListNode = dummy
    while (cur.next != null) {
      var i = 0
      while (i < k && cur != null) {
        cur = cur.next
        ++i
      }
      if (cur == null) {
        return dummy.next
      }
      val t: ListNode = cur.next
      cur.next = null
      val start: ListNode = pre.next
      pre.next = reverseList(start)
      start.next = t
      pre = start
      cur = pre
    }
    return dummy.next
  }

  private fun reverseList(head: ListNode): ListNode? {
    var pre: ListNode? = null
    var p: ListNode? = head
    while (p != null) {
      val q: ListNode = p.next
      p.next = pre
      pre = p
      p = q
    }
    return pre
  }
}
