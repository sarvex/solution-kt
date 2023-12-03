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
  fun detectCycle(head: ListNode): ListNode? {
    var fast: ListNode = head
    var slow: ListNode = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
      if (slow === fast) {
        var ans: ListNode = head
        while (ans !== slow) {
          ans = ans.next
          slow = slow.next
        }
        return ans
      }
    }
    return null
  }
}
