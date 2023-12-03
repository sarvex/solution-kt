import java.util.*
import kotlin.collections.ArrayDeque

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
internal class Solution {
  fun kthSmallest(root: TreeNode?, k: Int): Int {
    var root: TreeNode? = root
    var k = k
    val stk: Deque<TreeNode> = ArrayDeque()
    while (root != null || !stk.isEmpty()) {
      if (root != null) {
        stk.push(root)
        root = root.left
      } else {
        root = stk.pop()
        if (--k == 0) {
          return root.`val`
        }
        root = root.right
      }
    }
    return 0
  }
}
