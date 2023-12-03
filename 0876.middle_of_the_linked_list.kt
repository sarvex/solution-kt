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
  fun middleNode(head: ListNode): ListNode {
    var slow: ListNode = head
    var fast: ListNode = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    return slow
  }
}
