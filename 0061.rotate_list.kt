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
  fun rotateRight(head: ListNode, k: Int): ListNode {
    var k = k
    if (head == null || head.next == null) {
      return head
    }
    var cur: ListNode = head
    var n = 0
    while (cur != null) {
      n++
      cur = cur.next
    }
    k %= n
    if (k == 0) {
      return head
    }
    var fast: ListNode = head
    var slow: ListNode = head
    while (k-- > 0) {
      fast = fast.next
    }
    while (fast.next != null) {
      fast = fast.next
      slow = slow.next
    }
    val ans: ListNode = slow.next
    slow.next = null
    fast.next = head
    return ans
  }
}
