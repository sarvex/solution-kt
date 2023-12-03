/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
internal class Solution {
  private val visited: Map<Node, Node> = HashMap()
  fun cloneGraph(node: Node?): Node? {
    if (node == null) {
      return null
    }
    if (visited.containsKey(node)) {
      return visited[node]
    }
    val clone = Node(node.`val`)
    visited.put(node, clone)
    for (e in node.neighbors) {
      clone.neighbors.add(cloneGraph(e))
    }
    return clone
  }
}
