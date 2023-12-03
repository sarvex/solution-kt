class Solution {
  fun equalDigitFrequency(s: String): Int {
    val n = s.length
    val presum = Array(n + 1) { IntArray(10) }
    for (i in 0 until n) {
      ++presum[i + 1][s[i].code - '0'.code]
      for (j in 0..9) {
        presum[i + 1][j] += presum[i][j]
      }
    }
    val vis: Set<String> = HashSet()
    for (i in 0 until n) {
      for (j in i until n) {
        if (check(i, j, presum)) {
          vis.add(s.substring(i, j + 1))
        }
      }
    }
    return vis.size()
  }

  private fun check(i: Int, j: Int, presum: Array<IntArray>): Boolean {
    val v: Set<Int> = HashSet()
    for (k in 0..9) {
      val cnt = presum[j + 1][k] - presum[i][k]
      if (cnt > 0) {
        v.add(cnt)
      }
      if (v.size() > 1) {
        return false
      }
    }
    return true
  }
}
