import kotlin.math.max

class Solution {
  fun maximumSum(nums: IntArray): Int {
    val d = IntArray(100)
    var ans = -1
    for (v in nums) {
      var x = 0
      var y = v
      while (y > 0) {
        x += y % 10
        y /= 10
      }
      if (d[x] > 0) {
        ans = max(ans.toDouble(), (d[x] + v).toDouble()).toInt()
      }
      d[x] = max(d[x].toDouble(), v.toDouble()).toInt()
    }
    return ans
  }
}
