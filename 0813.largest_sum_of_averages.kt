import kotlin.math.max

internal class Solution {
  private var f: Array<Array<Double>>
  private var s: IntArray
  private var n = 0
  fun largestSumOfAverages(nums: IntArray, k: Int): Double {
    n = nums.size
    s = IntArray(n + 1)
    f = Array(n + 1) { arrayOfNulls(k + 1) }
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    return dfs(0, k)
  }

  private fun dfs(i: Int, k: Int): Double {
    if (i == n) {
      return 0
    }
    if (k == 1) {
      return (s[n] - s[i]) * 1.0 / (n - i)
    }
    if (f[i][k] != null) {
      return f[i][k]
    }
    var ans = 0.0
    for (j in i until n) {
      val t = (s[j + 1] - s[i]) * 1.0 / (j - i + 1) + dfs(j + 1, k - 1)
      ans = max(ans, t)
    }
    return ans.also { f[i][k] = it }
  }
}
