class Solution {
  private var m = 0
  fun colorTheGrid(m: Int, n: Int): Int {
    this.m = m
    val mod = 1e9.toInt() + 7
    val mx = 3.pow(m.toDouble()) as Int
    val valid: Set<Int> = HashSet()
    var f = IntArray(mx)
    for (i in 0 until mx) {
      if (f1(i)) {
        valid.add(i)
        f[i] = 1
      }
    }
    val d: Map<Int, List<Int>> = HashMap()
    for (i in valid) {
      for (j in valid) {
        if (f2(i, j)) {
          d.computeIfAbsent(i) { k -> ArrayList() }.add(j)
        }
      }
    }
    for (k in 1 until n) {
      val g = IntArray(mx)
      for (i in valid) {
        for (j in d[i] ?: List.of()) {
          g[i] = (g[i] + f[j]) % mod
        }
      }
      f = g
    }
    var ans = 0
    for (x in f) {
      ans = (ans + x) % mod
    }
    return ans
  }

  private fun f1(x: Int): Boolean {
    var x = x
    var last = -1
    for (i in 0 until m) {
      if (x % 3 == last) {
        return false
      }
      last = x % 3
      x /= 3
    }
    return true
  }

  private fun f2(x: Int, y: Int): Boolean {
    var x = x
    var y = y
    for (i in 0 until m) {
      if (x % 3 == y % 3) {
        return false
      }
      x /= 3
      y /= 3
    }
    return true
  }
}
