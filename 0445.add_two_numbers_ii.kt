import java.util.*
import kotlin.collections.ArrayDeque

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
  fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
    var l1: ListNode? = l1
    var l2: ListNode? = l2
    val s1: Deque<Int> = ArrayDeque()
    val s2: Deque<Int> = ArrayDeque()
    while (l1 != null) {
      s1.push(l1.`val`)
      l1 = l1.next
    }
    while (l2 != null) {
      s2.push(l2.`val`)
      l2 = l2.next
    }
    val dummy = ListNode()
    var carry = 0
    while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
      val s = (if (s1.isEmpty()) 0 else s1.pop()) + (if (s2.isEmpty()) 0 else s2.pop()) + carry
      // ListNode node = new ListNode(s % 10, dummy.next);
      // dummy.next = node;
      dummy.next = ListNode(s % 10, dummy.next)
      carry = s / 10
    }
    return dummy.next
  }
}
