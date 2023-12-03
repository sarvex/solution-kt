import kotlin.math.min

class Solution {
  fun minimumSeconds(nums: List<Int?>): Int {
    val d: Map<Int, List<Int>> = HashMap()
    val n: Int = nums.size()
    for (i in 0 until n) {
      d.computeIfAbsent(nums[i]) { k -> ArrayList() }.add(i)
    }
    var ans = 1 shl 30
    for (idx in d.values()) {
      val m: Int = idx.size()
      var t = idx[0] + n - idx[m - 1]
      for (i in 1 until m) {
        t = Math.max(t, idx[i] - idx[i - 1])
      }
      ans = min(ans.toDouble(), (t / 2).toDouble()).toInt()
    }
    return ans
  }
}
