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
  fun reverseList(head: ListNode): ListNode {
    val dummy = ListNode()
    var curr: ListNode = head
    while (curr != null) {
      val next: ListNode = curr.next
      curr.next = dummy.next
      dummy.next = curr
      curr = next
    }
    return dummy.next
  }
}
