class Solution {
  fun numOfWays(n: Int): Int {
    val mod = 1e9.toInt() + 7
    var f0: Long = 6
    var f1: Long = 6
    for (i in 0 until n - 1) {
      val g0 = (3 * f0 + 2 * f1) % mod
      val g1 = (2 * f0 + 2 * f1) % mod
      f0 = g0
      f1 = g1
    }
    return (f0 + f1).toInt() % mod
  }
}
