import kotlin.math.max

class Solution {
  fun deleteAndEarn(nums: IntArray): Int {
    if (nums.size == 0) {
      return 0
    }
    val sums = IntArray(10010)
    val select = IntArray(10010)
    val nonSelect = IntArray(10010)
    var maxV = 0
    for (x in nums) {
      sums[x] += x
      maxV = max(maxV.toDouble(), x.toDouble()).toInt()
    }
    for (i in 1..maxV) {
      select[i] = nonSelect[i - 1] + sums[i]
      nonSelect[i] = max(select[i - 1].toDouble(), nonSelect[i - 1].toDouble()).toInt()
    }
    return max(select[maxV].toDouble(), nonSelect[maxV].toDouble()).toInt()
  }
}
