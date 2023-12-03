class Solution {
  fun substringXorQueries(s: String, queries: Array<IntArray>): Array<IntArray> {
    val d: Map<Int, IntArray> = HashMap()
    val n = s.length
    for (i in 0 until n) {
      var x = 0
      var j = 0
      while (j < 32 && i + j < n) {
        x = x shl 1 or s[i + j].code - '0'.code
        d.putIfAbsent(x, intArrayOf(i, i + j))
        if (x == 0) {
          break
        }
        ++j
      }
    }
    val m = queries.size
    val ans = Array(m) { IntArray(2) }
    for (i in 0 until m) {
      val first = queries[i][0]
      val second = queries[i][1]
      val `val` = first xor second
      ans[i] = d[`val`] ?: intArrayOf(-1, -1)
    }
    return ans
  }
}
