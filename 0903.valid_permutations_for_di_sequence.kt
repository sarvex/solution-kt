internal class Solution {
  fun numPermsDISequence(s: String): Int {
    val mod = 1e9.toInt() + 7
    val n = s.length
    var f = IntArray(n + 1)
    f[0] = 1
    for (i in 1..n) {
      var pre = 0
      val g = IntArray(n + 1)
      if (s[i - 1] == 'D') {
        for (j in i downTo 0) {
          pre = (pre + f[j]) % mod
          g[j] = pre
        }
      } else {
        for (j in 0..i) {
          g[j] = pre
          pre = (pre + f[j]) % mod
        }
      }
      f = g
    }
    var ans = 0
    for (j in 0..n) {
      ans = (ans + f[j]) % mod
    }
    return ans
  }
}
