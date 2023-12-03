import kotlin.math.max

internal class Solution {
  fun lenLongestFibSubseq(arr: IntArray): Int {
    val n = arr.size
    val mp: Map<Int, Int> = HashMap()
    for (i in 0 until n) {
      mp.put(arr[i], i)
    }
    val dp = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      for (j in 0 until i) {
        dp[j][i] = 2
      }
    }
    var ans = 0
    for (i in 0 until n) {
      for (j in 0 until i) {
        val d = arr[i] - arr[j]
        if (mp.containsKey(d)) {
          val k = mp[d]!!
          if (k < j) {
            dp[j][i] = max(dp[j][i].toDouble(), (dp[k][j] + 1).toDouble())
              .toInt()
            ans = max(ans.toDouble(), dp[j][i].toDouble()).toInt()
          }
        }
      }
    }
    return ans
  }
}
