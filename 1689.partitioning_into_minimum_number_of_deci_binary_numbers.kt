import kotlin.math.max

class Solution {
  fun minPartitions(n: String): Int {
    var ans = 0
    for (i in 0 until n.length) {
      ans = max(ans.toDouble(), (n[i].code - '0'.code).toDouble()).toInt()
    }
    return ans
  }
}
