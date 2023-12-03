import kotlin.math.max

class Solution {
  fun smallestSubarrays(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(n)
    val f = IntArray(32)
    Arrays.fill(f, -1)
    for (i in n - 1 downTo 0) {
      var t = 1
      for (j in 0..31) {
        if (nums[i] shr j and 1 == 1) {
          f[j] = i
        } else if (f[j] != -1) {
          t = max(t.toDouble(), (f[j] - i + 1).toDouble()).toInt()
        }
      }
      ans[i] = t
    }
    return ans
  }
}
