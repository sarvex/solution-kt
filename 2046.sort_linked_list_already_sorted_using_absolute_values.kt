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
  fun sortLinkedList(head: ListNode): ListNode {
    var head: ListNode = head
    var prev: ListNode = head
    var curr: ListNode = head.next
    while (curr != null) {
      if (curr.`val` < 0) {
        val t: ListNode = curr.next
        prev.next = t
        curr.next = head
        head = curr
        curr = t
      } else {
        prev = curr
        curr = curr.next
      }
    }
    return head
  }
}
