class Solution {
  fun hardestWorker(n: Int, logs: Array<IntArray>): Int {
    var ans = 0
    var last = 0
    var mx = 0
    for (log in logs) {
      val uid = log[0]
      var t = log[1]
      t -= last
      if (mx < t || mx == t && ans > uid) {
        ans = uid
        mx = t
      }
      last += t
    }
    return ans
  }
}
