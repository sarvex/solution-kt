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
  fun getDecimalValue(head: ListNode?): Int {
    var head: ListNode? = head
    var ans = 0
    while (head != null) {
      ans = ans shl 1 or head.`val`
      head = head.next
    }
    return ans
  }
}
