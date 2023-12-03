class Solution {
  fun firstDayBeenInAllRooms(nextVisit: IntArray): Int {
    val n = nextVisit.size
    val f = LongArray(n)
    val mod = 1e9.toInt() + 7
    for (i in 1 until n) {
      f[i] = (f[i - 1] + 1 + f[i - 1] - f[nextVisit[i - 1]] + 1 + mod) % mod
    }
    return f[n - 1].toInt()
  }
}
