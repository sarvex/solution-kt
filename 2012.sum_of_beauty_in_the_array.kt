import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun sumOfBeauties(nums: IntArray): Int {
    val n = nums.size
    val lmx = IntArray(n)
    val rmi = IntArray(n)
    rmi[n - 1] = 100001
    for (i in 1 until n) {
      lmx[i] = max(lmx[i - 1].toDouble(), nums[i - 1].toDouble()).toInt()
    }
    for (i in n - 2 downTo 0) {
      rmi[i] = min(rmi[i + 1].toDouble(), nums[i + 1].toDouble()).toInt()
    }
    var ans = 0
    for (i in 1 until n - 1) {
      if (lmx[i] < nums[i] && nums[i] < rmi[i]) {
        ans += 2
      } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
        ans += 1
      }
    }
    return ans
  }
}
