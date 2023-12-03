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
  fun numComponents(head: ListNode?, nums: IntArray): Int {
    var head: ListNode? = head
    var ans = 0
    val s: Set<Int> = HashSet()
    for (v in nums) {
      s.add(v)
    }
    while (head != null) {
      while (head != null && !s.contains(head.`val`)) {
        head = head.next
      }
      ans += if (head != null) 1 else 0
      while (head != null && s.contains(head.`val`)) {
        head = head.next
      }
    }
    return ans
  }
}
