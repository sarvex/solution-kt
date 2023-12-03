import kotlin.math.min
import kotlin.math.sqrt

class Solution {
  fun solve(nums: IntArray, queries: Array<IntArray>): IntArray {
    val n = nums.size
    val m = sqrt(n.toDouble()).toInt()
    val mod = 1e9.toInt() + 7
    val suf = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in n - 1 downTo 0) {
        suf[i][j] = (suf[i][min(n.toDouble(), (j + i).toDouble()).toInt()] + nums[j]) % mod
      }
    }
    val k = queries.size
    val ans = IntArray(k)
    for (i in 0 until k) {
      val x = queries[i][0]
      val y = queries[i][1]
      if (y <= m) {
        ans[i] = suf[y][x]
      } else {
        var s = 0
        var j = x
        while (j < n) {
          s = (s + nums[j]) % mod
          j += y
        }
        ans[i] = s
      }
    }
    return ans
  }
}
