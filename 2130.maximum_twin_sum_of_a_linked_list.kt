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
  fun pairSum(head: ListNode): Int {
    var slow: ListNode = head
    var fast: ListNode = head.next
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    var pa: ListNode = head
    val q: ListNode = slow.next
    slow.next = null
    var pb: ListNode = reverse(q)
    var ans = 0
    while (pa != null) {
      ans = Math.max(ans, pa.`val` + pb.`val`)
      pa = pa.next
      pb = pb.next
    }
    return ans
  }

  private fun reverse(head: ListNode): ListNode {
    val dummy = ListNode()
    var curr: ListNode = head
    while (curr != null) {
      val next: ListNode = curr.next
      curr.next = dummy.next
      dummy.next = curr
      curr = next
    }
    return dummy.next
  }
}
