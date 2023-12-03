internal class Solution {
  fun shortestPalindrome(s: String): String {
    val base = 131
    var mul = 1
    val mod = 1e9.toInt() + 7
    var prefix = 0
    var suffix = 0
    var idx = 0
    val n = s.length
    for (i in 0 until n) {
      val t = s[i].code - 'a'.code + 1
      prefix = ((prefix.toLong() * base + t) % mod).toInt()
      suffix = ((suffix + t.toLong() * mul) % mod).toInt()
      mul = (mul.toLong() * base % mod).toInt()
      if (prefix == suffix) {
        idx = i + 1
      }
    }
    return if (idx == n) {
      s
    } else StringBuilder(s.substring(idx)).reverse().toString() + s
  }
}
