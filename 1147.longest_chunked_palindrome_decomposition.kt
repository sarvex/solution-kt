class Solution {
  fun longestDecomposition(text: String): Int {
    var ans = 0
    var i = 0
    var j = text.length - 1
    while (i <= j) {
      var ok = false
      var k = 1
      while (i + k - 1 < j - k + 1) {
        if (check(text, i, j - k + 1, k)) {
          ans += 2
          i += k
          j -= k
          ok = true
          break
        }
        ++k
      }
      if (!ok) {
        ++ans
        break
      }
    }
    return ans
  }

  private fun check(s: String, i: Int, j: Int, k: Int): Boolean {
    var i = i
    var j = j
    var k = k
    while (k-- > 0) {
      if (s[i++] != s[j++]) {
        return false
      }
    }
    return true
  }
}
