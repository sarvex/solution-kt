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
  fun connect(root: Node?): Node? {
    if (root == null) {
      return root
    }
    val q: Deque<Node> = ArrayDeque()
    q.offer(root)
    while (!q.isEmpty()) {
      var p: Node? = null
      for (n in q.size() downTo 1) {
        val node: Node = q.poll()
        if (p != null) {
          p.next = node
        }
        p = node
        if (node.left != null) {
          q.offer(node.left)
        }
        if (node.right != null) {
          q.offer(node.right)
        }
      }
    }
    return root
  }
}
