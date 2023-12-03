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
  fun reorderList(head: ListNode) {
    var fast: ListNode = head
    var slow: ListNode = head
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    var cur: ListNode? = slow.next
    slow.next = null
    var pre: ListNode? = null
    while (cur != null) {
      val t: ListNode = cur.next
      cur.next = pre
      pre = cur
      cur = t
    }
    cur = head
    while (pre != null) {
      val t: ListNode = pre.next
      pre.next = cur.next
      cur.next = pre
      cur = pre.next
      pre = t
    }
  }
}
