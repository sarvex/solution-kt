import kotlin.math.max
import kotlin.math.min

class Solution {
  private var cnt: IntArray
  private var ans = 0
  private var jobs: IntArray
  private var k = 0
  fun minimumTimeRequired(jobs: IntArray, k: Int): Int {
    this.k = k
    Arrays.sort(jobs)
    var i = 0
    var j = jobs.size - 1
    while (i < j) {
      val t = jobs[i]
      jobs[i] = jobs[j]
      jobs[j] = t
      ++i
      --j
    }
    this.jobs = jobs
    cnt = IntArray(k)
    ans = 0x3f3f3f3f
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    if (i == jobs.size) {
      var mx = 0
      for (v in cnt) {
        mx = max(mx.toDouble(), v.toDouble()).toInt()
      }
      ans = min(ans.toDouble(), mx.toDouble()).toInt()
      return
    }
    for (j in 0 until k) {
      if (cnt[j] + jobs[i] >= ans) {
        continue
      }
      cnt[j] += jobs[i]
      dfs(i + 1)
      cnt[j] -= jobs[i]
      if (cnt[j] == 0) {
        break
      }
    }
  }
}
