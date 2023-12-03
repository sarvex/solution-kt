class Solution {
  private var m = 0
  private var n = 0
  private var f: IntArray
  private var g: IntArray
  fun minimumScore(s: String, t: String): Int {
    m = s.length
    n = t.length
    f = IntArray(n)
    g = IntArray(n)
    for (i in 0 until n) {
      f[i] = 1 shl 30
      g[i] = -1
    }
    run {
      var i = 0
      var j = 0
      while (i < m && j < n) {
        if (s[i] == t[j]) {
          f[j] = i
          ++j
        }
        ++i
      }
    }
    var i = m - 1
    var j = n - 1
    while (i >= 0 && j >= 0) {
      if (s[i] == t[j]) {
        g[j] = i
        --j
      }
      --i
    }
    var l = 0
    var r = n
    while (l < r) {
      val mid = l + r shr 1
      if (check(mid)) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }

  private fun check(len: Int): Boolean {
    for (k in 0 until n) {
      val i = k - 1
      val j = k + len
      val l = if (i >= 0) f[i] else -1
      val r = if (j < n) g[j] else m + 1
      if (l < r) {
        return true
      }
    }
    return false
  }
}
