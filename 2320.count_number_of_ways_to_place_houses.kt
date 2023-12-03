class Solution {
  fun countHousePlacements(n: Int): Int {
    val mod = 1e9.toInt() + 7
    val f = IntArray(n)
    val g = IntArray(n)
    f[0] = 1
    g[0] = 1
    for (i in 1 until n) {
      f[i] = g[i - 1]
      g[i] = (f[i - 1] + g[i - 1]) % mod
    }
    val v = ((f[n - 1] + g[n - 1]) % mod).toLong()
    return (v * v % mod).toInt()
  }
}
