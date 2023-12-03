class Solution {
  private var f: IntArray
  private var lo = 0
  private var hi = 0
  private var zero = 0
  private var one = 0
  fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
    f = IntArray(high + 1)
    Arrays.fill(f, -1)
    lo = low
    hi = high
    this.zero = zero
    this.one = one
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    if (i > hi) {
      return 0
    }
    if (f[i] != -1) {
      return f[i]
    }
    var ans: Long = 0
    if (i >= lo && i <= hi) {
      ++ans
    }
    ans += (dfs(i + zero) + dfs(i + one)).toLong()
    ans %= Solution.Companion.MOD.toLong()
    f[i] = ans.toInt()
    return f[i]
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
