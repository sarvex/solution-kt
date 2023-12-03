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
  fun reverseBetween(head: ListNode, left: Int, right: Int): ListNode {
    if (head.next == null || left == right) {
      return head
    }
    val dummy = ListNode(0, head)
    var pre: ListNode = dummy
    for (i in 0 until left - 1) {
      pre = pre.next
    }
    val p: ListNode = pre
    val q: ListNode = pre.next
    var cur: ListNode = q
    for (i in 0 until right - left + 1) {
      val t: ListNode = cur.next
      cur.next = pre
      pre = cur
      cur = t
    }
    p.next = pre
    q.next = cur
    return dummy.next
  }
}
