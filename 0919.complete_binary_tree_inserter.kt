/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
internal class CBTInserter(root: TreeNode?) {
  private val tree: List<TreeNode>

  init {
    tree = ArrayList()
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    while (!q.isEmpty()) {
      val node: TreeNode = q.pollFirst()
      tree.add(node)
      if (node.left != null) {
        q.offer(node.left)
      }
      if (node.right != null) {
        q.offer(node.right)
      }
    }
  }

  fun insert(`val`: Int): Int {
    val pid: Int = tree.size() - 1 shr 1
    val node = TreeNode(`val`)
    tree.add(node)
    val p: TreeNode = tree[pid]
    if (p.left == null) {
      p.left = node
    } else {
      p.right = node
    }
    return p.`val`
  }

  fun get_root(): TreeNode {
    return tree[0]
  }
}
