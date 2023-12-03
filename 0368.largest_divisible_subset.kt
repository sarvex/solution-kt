import kotlin.math.max

internal class Solution {
  fun largestDivisibleSubset(nums: IntArray): List<Int> {
    Arrays.sort(nums)
    val n = nums.size
    val f = IntArray(n)
    Arrays.fill(f, 1)
    var k = 0
    for (i in 0 until n) {
      for (j in 0 until i) {
        if (nums[i] % nums[j] == 0) {
          f[i] = max(f[i].toDouble(), (f[j] + 1).toDouble()).toInt()
        }
      }
      if (f[k] < f[i]) {
        k = i
      }
    }
    var m = f[k]
    val ans: List<Int> = ArrayList()
    var i = k
    while (m > 0) {
      if (nums[k] % nums[i] == 0 && f[i] == m) {
        ans.add(nums[i])
        k = i
        --m
      }
      --i
    }
    return ans
  }
}
