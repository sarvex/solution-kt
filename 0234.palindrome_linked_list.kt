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
  fun isPalindrome(head: ListNode): Boolean {
    var head: ListNode = head
    var slow: ListNode = head
    var fast: ListNode = head.next
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    var cur: ListNode? = slow.next
    slow.next = null
    var pre: ListNode? = null
    while (cur != null) {
      val t: ListNode = cur.next
      cur.next = pre
      pre = cur
      cur = t
    }
    while (pre != null) {
      if (pre.`val` !== head.`val`) {
        return false
      }
      pre = pre.next
      head = head.next
    }
    return true
  }
}
