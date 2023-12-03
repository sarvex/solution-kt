/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
  fun hasCycle(head: ListNode): Boolean {
    var slow: ListNode = head
    var fast: ListNode = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
      if (slow === fast) {
        return true
      }
    }
    return false
  }
}
