import kotlin.math.max

internal class Solution {
  fun maxEqualFreq(nums: IntArray): Int {
    Arrays.fill(Solution.Companion.cnt, 0)
    Arrays.fill(Solution.Companion.ccnt, 0)
    var ans = 0
    var mx = 0
    for (i in 1..nums.size) {
      val v = nums[i - 1]
      if (Solution.Companion.cnt.get(v) > 0) {
        --Solution.Companion.ccnt.get(Solution.Companion.cnt.get(v))
      }
      ++Solution.Companion.cnt.get(v)
      mx = max(mx.toDouble(), Solution.Companion.cnt.get(v).toDouble()).toInt()
      ++Solution.Companion.ccnt.get(Solution.Companion.cnt.get(v))
      if (mx == 1) {
        ans = i
      } else if (Solution.Companion.ccnt.get(mx) * mx + Solution.Companion.ccnt.get(mx - 1) * (mx - 1) == i && Solution.Companion.ccnt.get(
          mx
        ) == 1
      ) {
        ans = i
      } else if (Solution.Companion.ccnt.get(mx) * mx + 1 == i && Solution.Companion.ccnt.get(1) == 1) {
        ans = i
      }
    }
    return ans
  }

  companion object {
    private val cnt = IntArray(100010)
    private val ccnt = IntArray(100010)
  }
}
