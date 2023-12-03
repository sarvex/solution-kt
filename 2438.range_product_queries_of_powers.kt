class Solution {
  fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
    var n = n
    val powers = IntArray(Integer.bitCount(n))
    run {
      var i = 0
      while (n > 0) {
        val x = n and -n
        powers[i] = x
        n -= x
        ++i
      }
    }
    val ans = IntArray(queries.size)
    for (i in ans.indices) {
      var x: Long = 1
      val l = queries[i][0]
      val r = queries[i][1]
      for (j in l..r) {
        x = x * powers[j] % Solution.Companion.MOD
      }
      ans[i] = x.toInt()
    }
    return ans
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
