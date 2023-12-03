import kotlin.math.max

class Solution {
  fun minimumMoney(transactions: Array<IntArray>): Long {
    var s: Long = 0
    for (e in transactions) {
      (s += max(0.0, (e[0] - e[1]).toDouble())).toLong()
    }
    var ans: Long = 0
    for (e in transactions) {
      ans = if (e[0] > e[1]) {
        max(ans.toDouble(), (s + e[1]).toDouble()).toLong()
      } else {
        max(ans.toDouble(), (s + e[0]).toDouble()).toLong()
      }
    }
    return ans
  }
}
