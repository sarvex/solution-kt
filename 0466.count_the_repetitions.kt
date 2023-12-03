internal class Solution {
  fun getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int {
    var n1 = n1
    val m = s1.length
    val n = s2.length
    val d = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      var j = i
      var cnt = 0
      for (k in 0 until m) {
        if (s1[k] == s2[j]) {
          if (++j == n) {
            j = 0
            ++cnt
          }
        }
      }
      d[i] = intArrayOf(cnt, j)
    }
    var ans = 0
    var j = 0
    while (n1 > 0) {
      ans += d[j][0]
      j = d[j][1]
      --n1
    }
    return ans / n2
  }
}
