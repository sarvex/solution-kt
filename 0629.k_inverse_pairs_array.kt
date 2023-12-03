import kotlin.math.max

internal class Solution {
  fun kInversePairs(n: Int, k: Int): Int {
    val mod = 1e9.toInt() + 7
    val f = IntArray(k + 1)
    val s = IntArray(k + 2)
    f[0] = 1
    Arrays.fill(s, 1)
    s[0] = 0
    for (i in 1..n) {
      for (j in 1..k) {
        f[j] = (s[j + 1] - s[max(0.0, (j - (i - 1)).toDouble()).toInt()] + mod) % mod
      }
      for (j in 1..k + 1) {
        s[j] = (s[j - 1] + f[j - 1]) % mod
      }
    }
    return f[k]
  }
}
