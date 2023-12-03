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
  fun doubleIt(head: ListNode): ListNode {
    var head: ListNode = head
    head = reverse(head)
    val dummy = ListNode()
    var cur: ListNode = dummy
    val mul = 2
    var carry = 0
    while (head != null) {
      val x: Int = head.`val` * mul + carry
      carry = x / 10
      cur.next = ListNode(x % 10)
      cur = cur.next
      head = head.next
    }
    if (carry > 0) {
      cur.next = ListNode(carry)
    }
    return reverse(dummy.next)
  }

  private fun reverse(head: ListNode): ListNode {
    val dummy = ListNode()
    var cur: ListNode = head
    while (cur != null) {
      val next: ListNode = cur.next
      cur.next = dummy.next
      dummy.next = cur
      cur = next
    }
    return dummy.next
  }
}
