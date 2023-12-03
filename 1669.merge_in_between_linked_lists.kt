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
  fun mergeInBetween(list1: ListNode, a: Int, b: Int, list2: ListNode): ListNode {
    var a = a
    var b = b
    var p: ListNode = list1
    var q: ListNode = list1
    while (--a > 0) {
      p = p.next
    }
    while (b-- > 0) {
      q = q.next
    }
    p.next = list2
    while (p.next != null) {
      p = p.next
    }
    p.next = q.next
    q.next = null
    return list1
  }
}
