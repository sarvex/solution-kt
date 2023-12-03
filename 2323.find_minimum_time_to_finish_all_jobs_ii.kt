import kotlin.math.max

class Solution {
  fun minimumTime(jobs: IntArray, workers: IntArray): Int {
    Arrays.sort(jobs)
    Arrays.sort(workers)
    var ans = 0
    for (i in jobs.indices) {
      ans = max(ans.toDouble(), ((jobs[i] + workers[i] - 1) / workers[i]).toDouble()).toInt()
    }
    return ans
  }
}
