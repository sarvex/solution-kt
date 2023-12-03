import kotlin.math.max

class Solution {
  fun minOperations(logs: Array<String>): Int {
    var ans = 0
    for (v in logs) {
      if ("../" == v) {
        ans = max(0.0, (ans - 1).toDouble()).toInt()
      } else if (v[0] != '.') {
        ++ans
      }
    }
    return ans
  }
}
