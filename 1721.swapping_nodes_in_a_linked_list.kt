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
  fun swapNodes(head: ListNode, k: Int): ListNode {
    var k = k
    var fast: ListNode = head
    while (--k > 0) {
      fast = fast.next
    }
    val p: ListNode = fast
    var slow: ListNode = head
    while (fast.next != null) {
      fast = fast.next
      slow = slow.next
    }
    val q: ListNode = slow
    val t: Int = p.`val`
    p.`val` = q.`val`
    q.`val` = t
    return head
  }
}
