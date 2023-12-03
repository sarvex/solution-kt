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
  fun mergeNodes(head: ListNode): ListNode {
    val dummy = ListNode()
    var s = 0
    var tail: ListNode = dummy
    var cur: ListNode = head.next
    while (cur != null) {
      if (cur.`val` !== 0) {
        s += cur.`val`
      } else {
        tail.next = ListNode(s)
        tail = tail.next
        s = 0
      }
      cur = cur.next
    }
    return dummy.next
  }
}
