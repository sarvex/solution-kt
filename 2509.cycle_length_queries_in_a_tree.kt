class Solution {
  fun cycleLengthQueries(n: Int, queries: Array<IntArray>): IntArray {
    val m = queries.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      var a = queries[i][0]
      var b = queries[i][1]
      var t = 1
      while (a != b) {
        if (a > b) {
          a = a shr 1
        } else {
          b = b shr 1
        }
        ++t
      }
      ans[i] = t
    }
    return ans
  }
}
