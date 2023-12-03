import kotlin.math.max

class Solution {
  fun countGoodSubsequences(s: String): Int {
    val cnt = IntArray(26)
    var mx = 1
    for (i in 0 until s.length) {
      mx = max(mx.toDouble(), ++cnt[s[i].code - 'a'.code].toDouble()).toInt()
    }
    var ans: Long = 0
    for (i in 1..mx) {
      var x: Long = 1
      for (j in 0..25) {
        if (cnt[j] >= i) {
          x = x * (Solution.Companion.comb(cnt[j], i) + 1) % Solution.Companion.MOD
        }
      }
      ans = (ans + x - 1) % Solution.Companion.MOD
    }
    return ans.toInt()
  }

  companion object {
    private const val N = 10001
    private const val MOD = 1e9.toInt() + 7
    private val F = LongArray(Solution.Companion.N)
    private val G = LongArray(Solution.Companion.N)

    init {
      Solution.Companion.F.get(0) = 1
      Solution.Companion.G.get(0) = 1
      for (i in 1 until Solution.Companion.N) {
        Solution.Companion.F.get(i) = Solution.Companion.F.get(i - 1) * i % Solution.Companion.MOD
        Solution.Companion.G.get(i) = Solution.Companion.qmi(
          Solution.Companion.F.get(i),
          (Solution.Companion.MOD - 2).toLong(),
          Solution.Companion.MOD.toLong()
        )
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
