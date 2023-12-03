import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minMoves(nums: IntArray, limit: Int): Int {
    val n = nums.size
    val d = IntArray(limit * 2 + 2)
    for (i in 0 until (n shr 1)) {
      val a = min(nums[i].toDouble(), nums[n - i - 1].toDouble()).toInt()
      val b = max(nums[i].toDouble(), nums[n - i - 1].toDouble()).toInt()
      d[2] += 2
      d[limit * 2 + 1] -= 2
      d[a + 1] -= 1
      d[b + limit + 1] += 1
      d[a + b] -= 1
      d[a + b + 1] += 1
    }
    var ans = n
    var s = 0
    for (i in 2..limit * 2) {
      s += d[i]
      if (ans > s) {
        ans = s
      }
    }
    return ans
  }
}
