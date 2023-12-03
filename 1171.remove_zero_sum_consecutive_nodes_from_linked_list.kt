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
  fun removeZeroSumSublists(head: ListNode?): ListNode {
    val dummy = ListNode(0, head)
    val last: Map<Int, ListNode> = HashMap()
    var s = 0
    var cur: ListNode = dummy
    while (cur != null) {
      s += cur.`val`
      last.put(s, cur)
      cur = cur.next
    }
    s = 0
    cur = dummy
    while (cur != null) {
      s += cur.`val`
      cur.next = last[s].next
      cur = cur.next
    }
    return dummy.next
  }
}
