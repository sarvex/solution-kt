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
  fun deleteDuplicates(head: ListNode?): ListNode {
    val dummy = ListNode(0, head)
    var pre: ListNode = dummy
    var cur: ListNode? = head
    while (cur != null) {
      while (cur.next != null && cur.next.`val` === cur.`val`) {
        cur = cur.next
      }
      if (pre.next === cur) {
        pre = cur
      } else {
        pre.next = cur.next
      }
      cur = cur.next
    }
    return dummy.next
  }
}
