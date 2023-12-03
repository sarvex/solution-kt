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
  fun deleteDuplicates(head: ListNode?): ListNode? {
    var cur: ListNode? = head
    while (cur != null && cur.next != null) {
      if (cur.`val` === cur.next.`val`) {
        cur.next = cur.next.next
      } else {
        cur = cur.next
      }
    }
    return head
  }
}
