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
  fun mergeTwoLists(list1: ListNode?, list2: ListNode): ListNode {
    var list1: ListNode? = list1
    var list2: ListNode = list2
    val dummy = ListNode()
    var curr: ListNode = dummy
    while (list1 != null && list2 != null) {
      if (list1.`val` <= list2.`val`) {
        curr.next = list1
        list1 = list1.next
      } else {
        curr.next = list2
        list2 = list2.next
      }
      curr = curr.next
    }
    curr.next = if (list1 == null) list2 else list1
    return dummy.next
  }
}
