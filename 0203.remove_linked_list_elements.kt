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
  fun removeElements(head: ListNode?, `val`: Int): ListNode {
    val dummy = ListNode(-1, head)
    var pre: ListNode = dummy
    while (pre.next != null) {
      if (pre.next.`val` !== `val`) pre = pre.next else pre.next = pre.next.next
    }
    return dummy.next
  }
}
