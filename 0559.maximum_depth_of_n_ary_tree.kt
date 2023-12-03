import kotlin.math.max

internal class Solution {
  fun maxDepth(root: Node?): Int {
    if (root == null) {
      return 0
    }
    var ans = 1
    for (child in root.children) {
      ans = max(ans.toDouble(), (1 + maxDepth(child)).toDouble()).toInt()
    }
    return ans
  }
}
