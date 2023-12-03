import kotlin.math.max

internal class Solution {
  fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
    val n = profit.size
    val jobs = Array(n) { IntArray(3) }
    for (i in 0 until n) {
      jobs[i] = intArrayOf(startTime[i], endTime[i], profit[i])
    }
    Arrays.sort(jobs) { a, b -> a.get(1) - b.get(1) }
    val dp = IntArray(n + 1)
    for (i in 0 until n) {
      val j = search(jobs, jobs[i][0], i)
      dp[i + 1] = max(dp[i].toDouble(), (dp[j] + jobs[i][2]).toDouble()).toInt()
    }
    return dp[n]
  }

  private fun search(jobs: Array<IntArray>, x: Int, n: Int): Int {
    var left = 0
    var right = n
    while (left < right) {
      val mid = left + right shr 1
      if (jobs[mid][1] > x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
