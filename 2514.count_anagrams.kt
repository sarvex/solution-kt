import java.math.BigInteger

internal class Solution {
  fun countAnagrams(s: String): Int {
    val n = s.length
    val f = LongArray(n + 1)
    f[0] = 1
    for (i in 1..n) {
      f[i] = f[i - 1] * i % Solution.Companion.MOD
    }
    var p: Long = 1
    for (w in s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      val cnt = IntArray(26)
      for (i in 0 until w.length) {
        ++cnt[w[i].code - 'a'.code]
      }
      p = p * f[w.length] % Solution.Companion.MOD
      for (v in cnt) {
        p = (p * BigInteger.valueOf(f[v]).modInverse(BigInteger.valueOf(Solution.Companion.MOD.toLong())).toInt()
            % Solution.Companion.MOD)
      }
    }
    return p.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
