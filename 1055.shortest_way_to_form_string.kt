internal class Solution {
  fun shortestWay(source: String, target: String): Int {
    val m = source.length
    val n = target.length
    var ans = 0
    var j = 0
    while (j < n) {
      var i = 0
      var ok = false
      while (i < m && j < n) {
        if (source[i] == target[j]) {
          ok = true
          ++j
        }
        ++i
      }
      if (!ok) {
        return -1
      }
      ++ans
    }
    return ans
  }
}
