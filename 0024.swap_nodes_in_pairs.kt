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
  fun swapPairs(head: ListNode): ListNode {
    val dummy = ListNode(0, head)
    var pre: ListNode = dummy
    var cur: ListNode = head
    while (cur != null && cur.next != null) {
      val t: ListNode = cur.next
      cur.next = t.next
      t.next = cur
      pre.next = t
      pre = cur
      cur = cur.next
    }
    return dummy.next
  }
}
