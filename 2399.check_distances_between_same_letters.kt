class Solution {
  fun checkDistances(s: String, distance: IntArray): Boolean {
    val d = IntArray(26)
    var i = 1
    val n = s.length
    while (i <= n) {
      val j = s[i - 1].code - 'a'.code
      if (d[j] > 0 && i - d[j] - 1 != distance[j]) {
        return false
      }
      d[j] = i
      ++i
    }
    return true
  }
}
