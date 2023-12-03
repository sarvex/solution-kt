/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
internal class Solution {
  fun deleteNode(node: ListNode) {
    node.`val` = node.next.`val`
    node.next = node.next.next
  }
}
