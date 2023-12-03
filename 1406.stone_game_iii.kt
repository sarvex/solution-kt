import kotlin.math.max

class Solution {
  private var stoneValue: IntArray
  private var f: Array<Int>
  private var n = 0
  fun stoneGameIII(stoneValue: IntArray): String {
    n = stoneValue.size
    f = arrayOfNulls(n)
    this.stoneValue = stoneValue
    val ans = dfs(0)
    if (ans == 0) {
      return "Tie"
    }
    return if (ans > 0) "Alice" else "Bob"
  }

  private fun dfs(i: Int): Int {
    if (i >= n) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    var ans = -(1 shl 30)
    var s = 0
    var j = 0
    while (j < 3 && i + j < n) {
      s += stoneValue[i + j]
      ans = max(ans.toDouble(), (s - dfs(i + j + 1)).toDouble()).toInt()
      ++j
    }
    return ans.also { f[i] = it }
  }
}
