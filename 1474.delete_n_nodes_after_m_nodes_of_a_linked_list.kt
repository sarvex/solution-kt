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
  fun deleteNodes(head: ListNode?, m: Int, n: Int): ListNode? {
    var pre: ListNode? = head
    while (pre != null) {
      run {
        var i = 0
        while (i < m - 1 && pre != null) {
          pre = pre.next
          ++i
        }
      }
      if (pre == null) {
        return head
      }
      var cur: ListNode? = pre
      var i = 0
      while (i < n && cur != null) {
        cur = cur.next
        ++i
      }
      pre.next = if (cur == null) null else cur.next
      pre = pre.next
    }
    return head
  }
}
