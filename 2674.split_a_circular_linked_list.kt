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
  fun splitCircularLinkedList(list: ListNode): Array<ListNode> {
    var a: ListNode = list
    var b: ListNode = list
    while (b.next !== list && b.next.next !== list) {
      a = a.next
      b = b.next.next
    }
    if (b.next !== list) {
      b = b.next
    }
    val list2: ListNode = a.next
    b.next = list2
    a.next = list
    return arrayOf<ListNode>(list, list2)
  }
}
