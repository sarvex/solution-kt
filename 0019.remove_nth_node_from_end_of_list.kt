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
  fun removeNthFromEnd(head: ListNode?, n: Int): ListNode {
    var n = n
    val dummy = ListNode(0, head)
    var fast: ListNode = dummy
    var slow: ListNode = dummy
    while (n-- > 0) {
      fast = fast.next
    }
    while (fast.next != null) {
      slow = slow.next
      fast = fast.next
    }
    slow.next = slow.next.next
    return dummy.next
  }
}
