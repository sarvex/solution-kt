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
  fun deleteDuplicatesUnsorted(head: ListNode?): ListNode {
    val cnt: Map<Int, Int> = HashMap()
    run {
      var cur: ListNode? = head
      while (cur != null) {
        cnt.put(cur.`val`, (cnt[cur.`val`] ?: 0) + 1)
        cur = cur.next
      }
    }
    val dummy = ListNode(0, head)
    var pre: ListNode = dummy
    var cur: ListNode? = head
    while (cur != null) {
      if (cnt[cur.`val`]!! > 1) {
        pre.next = cur.next
      } else {
        pre = cur
      }
      cur = cur.next
    }
    return dummy.next
  }
}
