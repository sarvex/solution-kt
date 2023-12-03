import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

internal class Solution {
  fun levelOrder(root: Node?): List<List<Int>> {
    var root = root
    val ans: List<List<Int>> = ArrayList()
    if (root == null) {
      return ans
    }
    val q: Deque<Node> = ArrayDeque()
    q.offer(root)
    while (!q.isEmpty()) {
      val t: List<Int> = ArrayList()
      for (n in q.size() downTo 1) {
        root = q.poll()
        t.add(root.`val`)
        q.addAll(root.children)
      }
      ans.add(t)
    }
    return ans
  }
}
