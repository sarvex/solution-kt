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
  fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
    var l1: ListNode? = l1
    var l2: ListNode? = l2
    val dummy = ListNode(0)
    var carry = 0
    var cur: ListNode = dummy
    while (l1 != null || l2 != null || carry != 0) {
      val s: Int = (if (l1 == null) 0 else l1.`val`) + (if (l2 == null) 0 else l2.`val`) + carry
      carry = s / 10
      cur.next = ListNode(s % 10)
      cur = cur.next
      l1 = if (l1 == null) null else l1.next
      l2 = if (l2 == null) null else l2.next
    }
    return dummy.next
  }
}
