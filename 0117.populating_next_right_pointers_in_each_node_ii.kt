/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
internal class Solution {
  private var prev: Node? = null
  private var next: Node? = null
  fun connect(root: Node?): Node? {
    var node = root
    while (node != null) {
      prev = null
      next = null
      while (node != null) {
        modify(node.left)
        modify(node.right)
        node = node.next
      }
      node = next
    }
    return root
  }

  private fun modify(curr: Node?) {
    if (curr == null) {
      return
    }
    if (next == null) {
      next = curr
    }
    if (prev != null) {
      prev!!.next = curr
    }
    prev = curr
  }
}
