/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
  fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var a: ListNode? = headA
    var b: ListNode? = headB
    while (a !== b) {
      a = if (a == null) headB else a.next
      b = if (b == null) headA else b.next
    }
    return a
  }
}
