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
  fun insertionSortList(head: ListNode?): ListNode? {
    if (head == null || head.next == null) {
      return head
    }
    val dummy = ListNode(head.`val`, head)
    var pre: ListNode = dummy
    var cur: ListNode = head
    while (cur != null) {
      if (pre.`val` <= cur.`val`) {
        pre = cur
        cur = cur.next
        continue
      }
      var p: ListNode = dummy
      while (p.next.`val` <= cur.`val`) {
        p = p.next
      }
      val t: ListNode = cur.next
      cur.next = p.next
      p.next = cur
      pre.next = t
      cur = t
    }
    return dummy.next
  }
}
