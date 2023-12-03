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
  fun partition(head: ListNode?, x: Int): ListNode {
    var head: ListNode? = head
    val d1 = ListNode()
    val d2 = ListNode()
    var t1: ListNode = d1
    var t2: ListNode = d2
    while (head != null) {
      if (head.`val` < x) {
        t1.next = head
        t1 = t1.next
      } else {
        t2.next = head
        t2 = t2.next
      }
      head = head.next
    }
    t1.next = d2.next
    t2.next = null
    return d1.next
  }
}
