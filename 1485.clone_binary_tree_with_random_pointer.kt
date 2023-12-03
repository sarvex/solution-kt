/**
 * Definition for Node.
 * public class Node {
 * int val;
 * Node left;
 * Node right;
 * Node random;
 * Node() {}
 * Node(int val) { this.val = val; }
 * Node(int val, Node left, Node right, Node random) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * this.random = random;
 * }
 * }
 */
internal class Solution {
  private var mp: Map<Node, NodeCopy>? = null
  fun copyRandomBinaryTree(root: Node?): NodeCopy? {
    mp = HashMap()
    return dfs(root)
  }

  private fun dfs(root: Node?): NodeCopy? {
    if (root == null) {
      return null
    }
    if (mp!!.containsKey(root)) {
      return mp!![root]
    }
    val copy = NodeCopy(root.`val`)
    mp.put(root, copy)
    copy.left = dfs(root.left)
    copy.right = dfs(root.right)
    copy.random = dfs(root.random)
    return copy
  }
}
