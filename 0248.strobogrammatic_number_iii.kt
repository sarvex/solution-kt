internal class Solution {
  private var n = 0
  fun strobogrammaticInRange(low: String, high: String): Int {
    val a = low.length
    val b = high.length
    val l = low.toLong()
    val r = high.toLong()
    var ans = 0
    n = a
    while (n <= b) {
      for (s in dfs(n)) {
        val v = s.toLong()
        if (l <= v && v <= r) {
          ++ans
        }
      }
      ++n
    }
    return ans
  }

  private fun dfs(u: Int): List<String> {
    if (u == 0) {
      return Collections.singletonList("")
    }
    if (u == 1) {
      return Arrays.asList("0", "1", "8")
    }
    val ans: List<String> = ArrayList()
    for (v in dfs(u - 2)) {
      for (p in Solution.Companion.PAIRS) {
        ans.add(p[0].toString() + v + p[1])
      }
      if (u != n) {
        ans.add(0.toString() + v + 0)
      }
    }
    return ans
  }

  companion object {
    private val PAIRS = arrayOf(intArrayOf(1, 1), intArrayOf(8, 8), intArrayOf(6, 9), intArrayOf(9, 6))
  }
}
