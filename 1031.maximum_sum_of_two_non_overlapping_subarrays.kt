import kotlin.math.max

internal class Solution {
  fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
    val n = nums.size
    val s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    var ans = 0
    run {
      var i = firstLen
      var t = 0
      while (i + secondLen - 1 < n) {
        t = max(t.toDouble(), (s[i] - s[i - firstLen]).toDouble()).toInt()
        ans = max(ans.toDouble(), (t + s[i + secondLen] - s[i]).toDouble()).toInt()
        ++i
      }
    }
    var i = secondLen
    var t = 0
    while (i + firstLen - 1 < n) {
      t = max(t.toDouble(), (s[i] - s[i - secondLen]).toDouble()).toInt()
      ans = max(ans.toDouble(), (t + s[i + firstLen] - s[i]).toDouble()).toInt()
      ++i
    }
    return ans
  }
}
