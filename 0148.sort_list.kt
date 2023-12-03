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
  fun sortList(head: ListNode): ListNode {
    if (head == null || head.next == null) {
      return head
    }
    var slow: ListNode = head
    var fast: ListNode = head.next
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    val t: ListNode = slow.next
    slow.next = null
    var l1: ListNode = sortList(head)
    var l2: ListNode = sortList(t)
    val dummy = ListNode()
    var cur: ListNode = dummy
    while (l1 != null && l2 != null) {
      if (l1.`val` <= l2.`val`) {
        cur.next = l1
        l1 = l1.next
      } else {
        cur.next = l2
        l2 = l2.next
      }
      cur = cur.next
    }
    cur.next = if (l1 == null) l2 else l1
    return dummy.next
  }
}
