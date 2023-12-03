import kotlin.math.max

class Solution {
  fun longestSquareStreak(nums: IntArray): Int {
    val s: Set<Int> = HashSet()
    for (v in nums) {
      s.add(v)
    }
    var ans = -1
    for (v in nums) {
      var t = 0
      while (s.contains(v)) {
        v *= v
        ++t
      }
      if (t > 1) {
        ans = max(ans.toDouble(), t.toDouble()).toInt()
      }
    }
    return ans
  }
}
