import kotlin.math.min

internal class Solution {
  private var memo: IntArray
  private var s: IntArray
  private var n = 0
  fun minimumCost(sentence: String, k: Int): Int {
    val words = sentence.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    n = words.size
    s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + words[i].length
    }
    memo = IntArray(n)
    Arrays.fill(memo, Solution.Companion.INF)
    return dfs(0, k)
  }

  private fun dfs(i: Int, k: Int): Int {
    if (memo[i] != Solution.Companion.INF) {
      return memo[i]
    }
    if (s[n] - s[i] + n - i - 1 <= k) {
      memo[i] = 0
      return 0
    }
    var ans: Int = Solution.Companion.INF
    for (j in i + 1 until n) {
      val t = s[j] - s[i] + j - i - 1
      if (t <= k) {
        ans = min(ans.toDouble(), ((k - t) * (k - t) + dfs(j, k)).toDouble()).toInt()
      }
    }
    memo[i] = ans
    return ans
  }

  companion object {
    private const val INF = Int.MAX_VALUE
  }
}
