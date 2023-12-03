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
  fun deleteMiddle(head: ListNode?): ListNode {
    val dummy = ListNode(0, head)
    var slow: ListNode = dummy
    var fast: ListNode? = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    slow.next = slow.next.next
    return dummy.next
  }
}
