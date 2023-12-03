class Solution {
  private var s: String? = null
  fun numWays(s: String): Int {
    this.s = s
    var cnt = 0
    val n = s.length
    for (i in 0 until n) {
      if (s[i] == '1') {
        ++cnt
      }
    }
    val m = cnt % 3
    if (m != 0) {
      return 0
    }
    val mod = 1e9.toInt() + 7
    if (cnt == 0) {
      return ((n - 1L) * (n - 2) / 2 % mod).toInt()
    }
    cnt /= 3
    val i1 = find(cnt).toLong()
    val i2 = find(cnt + 1).toLong()
    val j1 = find(cnt * 2).toLong()
    val j2 = find(cnt * 2 + 1).toLong()
    return ((i2 - i1) * (j2 - j1) % mod).toInt()
  }

  private fun find(x: Int): Int {
    var t = 0
    var i = 0
    while (true) {
      t += if (s!![i] == '1') 1 else 0
      if (t == x) {
        return i
      }
      ++i
    }
  }
}
