import kotlin.math.min

class Solution {
  private var n = 0
  private var f: IntArray
  private var nums: IntArray
  private val inf = 0x3f3f3f3f
  fun validSubarraySplit(nums: IntArray): Int {
    n = nums.size
    f = IntArray(n)
    this.nums = nums
    val ans = dfs(0)
    return if (ans < inf) ans else -1
  }

  private fun dfs(i: Int): Int {
    if (i >= n) {
      return 0
    }
    if (f[i] > 0) {
      return f[i]
    }
    var ans = inf
    for (j in i until n) {
      if (gcd(nums[i], nums[j]) > 1) {
        ans = min(ans.toDouble(), (1 + dfs(j + 1)).toDouble()).toInt()
      }
    }
    f[i] = ans
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
