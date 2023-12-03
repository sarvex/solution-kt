class Solution {
  private var f: Array<Array<Boolean>>
  private var s: IntArray
  private var m = 0
  fun canSplitArray(nums: List<Int>, m: Int): Boolean {
    val n: Int = nums.size()
    f = Array(n) { arrayOfNulls(n) }
    s = IntArray(n + 1)
    for (i in 1..n) {
      s[i] = s[i - 1] + nums[i - 1]
    }
    this.m = m
    return dfs(0, n - 1)
  }

  private fun dfs(i: Int, j: Int): Boolean {
    if (i == j) {
      return true
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    for (k in i until j) {
      val a = k == i || s[k + 1] - s[i] >= m
      val b = k == j - 1 || s[j + 1] - s[k + 1] >= m
      if (a && b && dfs(i, k) && dfs(k + 1, j)) {
        return true.also { f[i][j] = it }
      }
    }
    return false.also { f[i][j] = it }
  }
}
