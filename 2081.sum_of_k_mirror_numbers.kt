internal class Solution {
  fun kMirror(k: Int, n: Int): Long {
    var n = n
    var ans: Long = 0
    var l = 1
    while (true) {
      val x = 10.pow(((l - 1) / 2).toDouble()) as Int
      val y = 10.pow(((l + 1) / 2).toDouble()) as Int
      for (i in x until y) {
        var v = i.toLong()
        var j = if (l % 2 == 0) i else i / 10
        while (j > 0) {
          v = v * 10 + j % 10
          j /= 10
        }
        val ss = v.toString(k.coerceIn(2, 36))
        if (check(ss.toCharArray())) {
          ans += v
          if (--n == 0) {
            return ans
          }
        }
      }
      ++l
    }
  }

  private fun check(c: CharArray): Boolean {
    var i = 0
    var j = c.size - 1
    while (i < j) {
      if (c[i] != c[j]) {
        return false
      }
      i++
      j--
    }
    return true
  }
}
