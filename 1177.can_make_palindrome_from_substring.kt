internal class Solution {
  fun canMakePaliQueries(s: String, queries: Array<IntArray>): List<Boolean> {
    val n = s.length
    val ss = Array(n + 1) { IntArray(26) }
    for (i in 1..n) {
      for (j in 0..25) {
        ss[i][j] = ss[i - 1][j]
      }
      ss[i][s[i - 1].code - 'a'.code]++
    }
    val ans: List<Boolean> = ArrayList()
    for (q in queries) {
      val l = q[0]
      val r = q[1]
      val k = q[2]
      var x = 0
      for (j in 0..25) {
        x += ss[r + 1][j] - ss[l][j] and 1
      }
      ans.add(x / 2 <= k)
    }
    return ans
  }
}
