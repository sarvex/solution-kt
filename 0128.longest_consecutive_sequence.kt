import kotlin.math.max

internal class Solution {
  fun longestConsecutive(nums: IntArray): Int {
    val s: Set<Int> = HashSet()
    for (x in nums) {
      s.add(x)
    }
    var ans = 0
    for (x in nums) {
      if (!s.contains(x - 1)) {
        var y = x + 1
        while (s.contains(y)) {
          ++y
        }
        ans = max(ans.toDouble(), (y - x).toDouble()).toInt()
      }
    }
    return ans
  }
}
