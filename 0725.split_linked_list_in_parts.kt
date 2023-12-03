/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
internal class Solution {
  fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
    var n = 0
    var cur: ListNode? = root
    while (cur != null) {
      ++n
      cur = cur.next
    }
    // width 表示每一部分至少含有的结点个数
    // remainder 表示前 remainder 部分，每一部分多出一个数
    val width = n / k
    val remainder = n % k
    val res: Array<ListNode?> = arrayOfNulls<ListNode>(k)
    cur = root
    for (i in 0 until k) {
      val head: ListNode? = cur
      for (j in 0 until width + (if (i < remainder) 1 else 0) - 1) {
        if (cur != null) {
          cur = cur.next
        }
      }
      if (cur != null) {
        val t: ListNode = cur.next
        cur.next = null
        cur = t
      }
      res[i] = head
    }
    return res
  }
}
