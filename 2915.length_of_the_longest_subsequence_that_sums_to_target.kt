import kotlin.math.max

class Solution {
  fun lengthOfLongestSubsequence(nums: List<Int>, target: Int): Int {
    val f = IntArray(target + 1)
    val inf = 1 shl 30
    Arrays.fill(f, -inf)
    f[0] = 0
    for (x in nums) {
      for (j in target downTo x) {
        f[j] = max(f[j].toDouble(), (f[j - x] + 1).toDouble()).toInt()
      }
    }
    return if (f[target] <= 0) -1 else f[target]
  }
}
