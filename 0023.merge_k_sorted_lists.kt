import java.util.*

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
  fun mergeKLists(lists: Array<ListNode?>): ListNode {
    val pq: PriorityQueue<ListNode> = PriorityQueue { a, b -> a.`val` - b.`val` }
    for (head in lists) {
      if (head != null) {
        pq.offer(head)
      }
    }
    val dummy = ListNode()
    var cur: ListNode = dummy
    while (!pq.isEmpty()) {
      val node: ListNode = pq.poll()
      if (node.next != null) {
        pq.offer(node.next)
      }
      cur.next = node
      cur = cur.next
    }
    return dummy.next
  }
}
