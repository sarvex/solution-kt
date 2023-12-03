class Solution {
  fun waysToFillArray(queries: Array<IntArray>): IntArray {
    val m = queries.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      val n = queries[i][0]
      val k = queries[i][1]
      var t: Long = 1
      for (x in Solution.Companion.P.get(k)) {
        t = t * Solution.Companion.comb(x + n - 1, n - 1) % Solution.Companion.MOD
      }
      ans[i] = t.toInt()
    }
    return ans
  }

  companion object {
    private const val N = 10020
    private const val MOD = 1e9.toInt() + 7
    private val F = LongArray(Solution.Companion.N)
    private val G = LongArray(Solution.Companion.N)
    private val P: Array<List<Int>?> = arrayOfNulls<List>(Solution.Companion.N)

    init {
      Solution.Companion.F.get(0) = 1
      Solution.Companion.G.get(0) = 1
      Arrays.setAll(Solution.Companion.P) { k -> ArrayList() }
      for (i in 1 until Solution.Companion.N) {
        Solution.Companion.F.get(i) = Solution.Companion.F.get(i - 1) * i % Solution.Companion.MOD
        Solution.Companion.G.get(i) = Solution.Companion.qmi(
          Solution.Companion.F.get(i),
          (Solution.Companion.MOD - 2).toLong(),
          Solution.Companion.MOD.toLong()
        )
        var x = i
        for (j in 2..x / j) {
          if (x % j == 0) {
            var cnt = 0
            while (x % j == 0) {
              ++cnt
              x /= j
            }
            Solution.Companion.P.get(i).add(cnt)
          }
        }
        if (x > 1) {
          Solution.Companion.P.get(i).add(1)
        }
      }
    }

    fun qmi(a: Long, k: Long, p: Long): Long {
      var a = a
      var k = k
      var res: Long = 1
      while (k != 0L) {
        if (k and 1L == 1L) {
          res = res * a % p
        }
        k = k shr 1
        a = a * a % p
      }
      return res
    }

    fun comb(n: Int, k: Int): Long {
      return Solution.Companion.F.get(n) * Solution.Companion.G.get(k) % Solution.Companion.MOD * Solution.Companion.G.get(
        n - k
      ) % Solution.Companion.MOD
    }
  }
}
