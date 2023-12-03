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
  fun insertGreatestCommonDivisors(head: ListNode): ListNode {
    var pre: ListNode = head
    var cur: ListNode = head.next
    while (cur != null) {
      val x = gcd(pre.`val`, cur.`val`)
      pre.next = ListNode(x, cur)
      pre = cur
      cur = cur.next
    }
    return head
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) {
      a
    } else gcd(b, a % b)
  }
}
