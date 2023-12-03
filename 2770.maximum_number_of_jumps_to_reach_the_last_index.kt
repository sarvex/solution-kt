import kotlin.math.abs
import kotlin.math.max

class Solution {
  private var f: Array<Int>
  private var nums: IntArray
  private var n = 0
  private var target = 0
  fun maximumJumps(nums: IntArray, target: Int): Int {
    n = nums.size
    this.target = target
    this.nums = nums
    f = arrayOfNulls(n)
    val ans = dfs(0)
    return if (ans < 0) -1 else ans
  }

  private fun dfs(i: Int): Int {
    if (i == n - 1) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    var ans = -(1 shl 30)
    for (j in i + 1 until n) {
      if (abs((nums[i] - nums[j]).toDouble()) <= target) {
        ans = max(ans.toDouble(), (1 + dfs(j)).toDouble()).toInt()
      }
    }
    return ans.also { f[i] = it }
  }
}
