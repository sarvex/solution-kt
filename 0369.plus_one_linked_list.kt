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
  fun plusOne(head: ListNode?): ListNode {
    var head: ListNode? = head
    val dummy = ListNode(0, head)
    var target: ListNode? = dummy
    while (head != null) {
      if (head.`val` !== 9) {
        target = head
      }
      head = head.next
    }
    ++target.`val`
    target = target.next
    while (target != null) {
      target.`val` = 0
      target = target.next
    }
    return if (dummy.`val` === 1) dummy else dummy.next
  }
}
