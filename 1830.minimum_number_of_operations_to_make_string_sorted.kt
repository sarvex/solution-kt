class Solution {
  fun makeStringSorted(s: String): Int {
    val cnt = IntArray(26)
    val n = s.length
    for (i in 0 until n) {
      ++cnt[s[i].code - 'a'.code]
    }
    var ans: Long = 0
    for (i in 0 until n) {
      var m = 0
      for (j in s[i].code - 'a'.code - 1 downTo 0) {
        m += cnt[j]
      }
      var t: Long = m * Solution.Companion.f.get(n - i - 1) % Solution.Companion.MOD
      for (v in cnt) {
        t = t * Solution.Companion.g.get(v) % Solution.Companion.MOD
      }
      --cnt[s[i].code - 'a'.code]
      ans = (ans + t + Solution.Companion.MOD) % Solution.Companion.MOD
    }
    return ans.toInt()
  }

  companion object {
    private const val N = 3010
    private const val MOD = 1e9.toInt() + 7
    private val f = LongArray(Solution.Companion.N)
    private val g = LongArray(Solution.Companion.N)

    init {
      Solution.Companion.f.get(0) = 1
      Solution.Companion.g.get(0) = 1
      for (i in 1 until Solution.Companion.N) {
        Solution.Companion.f.get(i) = Solution.Companion.f.get(i - 1) * i % Solution.Companion.MOD
        Solution.Companion.g.get(i) = Solution.Companion.qmi(Solution.Companion.f.get(i), Solution.Companion.MOD - 2)
      }
    }

    fun qmi(a: Long, k: Int): Long {
      var a = a
      var k = k
      var res: Long = 1
      while (k != 0) {
        if (k and 1 == 1) {
          res = res * a % Solution.Companion.MOD
        }
        k = k shr 1
        a = a * a % Solution.Companion.MOD
      }
      return res
    }
  }
}
