/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
internal class Solution {
  fun copyRandomList(head: Node?): Node? {
    if (head == null) {
      return null
    }
    run {
      var cur = head
      while (cur != null) {
        val node = Node(cur!!.`val`, cur!!.next)
        cur!!.next = node
        cur = node.next
      }
    }
    run {
      var cur = head
      while (cur != null) {
        if (cur.random != null) {
          cur!!.next.random = cur.random.next
        }
        cur = cur!!.next!!.next
      }
    }
    val ans = head.next
    var cur = head
    while (cur != null) {
      val nxt = cur!!.next
      if (nxt != null) {
        cur!!.next = nxt.next
      }
      cur = nxt
    }
    return ans
  }
}
