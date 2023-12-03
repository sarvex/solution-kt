internal class Solution {
  fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
    val n = s.length
    val presum = IntArray(n + 1)
    for (i in 0 until n) {
      presum[i + 1] = presum[i] + if (s[i] == '*') 1 else 0
    }
    val left = IntArray(n)
    val right = IntArray(n)
    run {
      var i = 0
      var l = -1
      while (i < n) {
        if (s[i] == '|') {
          l = i
        }
        left[i] = l
        ++i
      }
    }
    var i = n - 1
    var r = -1
    while (i >= 0) {
      if (s[i] == '|') {
        r = i
      }
      right[i] = r
      --i
    }
    val ans = IntArray(queries.size)
    for (k in queries.indices) {
      val i = right[queries[k][0]]
      val j = left[queries[k][1]]
      if (i >= 0 && j >= 0 && i < j) {
        ans[k] = presum[j] - presum[i + 1]
      }
    }
    return ans
  }
}
