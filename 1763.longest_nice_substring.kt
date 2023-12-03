class Solution {
  fun longestNiceSubstring(s: String): String {
    val n = s.length
    var k = -1
    var mx = 0
    for (i in 0 until n) {
      var lower = 0
      var upper = 0
      for (j in i until n) {
        val c = s[j]
        if (Character.isLowerCase(c)) {
          lower = lower or (1 shl c.code - 'a'.code)
        } else {
          upper = upper or (1 shl c.code - 'A'.code)
        }
        if (lower == upper && mx < j - i + 1) {
          mx = j - i + 1
          k = i
        }
      }
    }
    return if (k == -1) "" else s.substring(k, k + mx)
  }
}
