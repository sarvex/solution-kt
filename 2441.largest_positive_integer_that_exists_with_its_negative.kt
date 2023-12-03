import kotlin.math.max

class Solution {
  fun findMaxK(nums: IntArray): Int {
    var ans = -1
    val s: Set<Int> = HashSet()
    for (x in nums) {
      s.add(x)
    }
    for (x in s) {
      if (s.contains(-x)) {
        ans = max(ans.toDouble(), x.toDouble()).toInt()
      }
    }
    return ans
  }
}
