import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

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
  fun nextLargerNodes(head: ListNode?): IntArray {
    var head: ListNode? = head
    val nums: List<Int> = ArrayList()
    while (head != null) {
      nums.add(head.`val`)
      head = head.next
    }
    val stk: Deque<Int> = ArrayDeque()
    val n: Int = nums.size()
    val ans = IntArray(n)
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && stk.peek() <= nums[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        ans[i] = stk.peek()
      }
      stk.push(nums[i])
    }
    return ans
  }
}
