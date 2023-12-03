import kotlin.math.min

class Solution {
  fun maxDivScore(nums: IntArray, divisors: IntArray): Int {
    var ans = divisors[0]
    var mx = 0
    for (div in divisors) {
      var cnt = 0
      for (x in nums) {
        if (x % div == 0) {
          ++cnt
        }
      }
      if (mx < cnt) {
        mx = cnt
        ans = div
      } else if (mx == cnt) {
        ans = min(ans.toDouble(), div.toDouble()).toInt()
      }
    }
    return ans
  }
}
