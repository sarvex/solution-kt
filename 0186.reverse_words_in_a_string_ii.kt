internal class Solution {
  fun reverseWords(s: CharArray) {
    val n = s.size
    var i = 0
    var j = 0
    while (j < n) {
      if (s[j] == ' ') {
        reverse(s, i, j - 1)
        i = j + 1
      } else if (j == n - 1) {
        reverse(s, i, j)
      }
      ++j
    }
    reverse(s, 0, n - 1)
  }

  private fun reverse(s: CharArray, i: Int, j: Int) {
    var i = i
    var j = j
    while (i < j) {
      val t = s[i]
      s[i] = s[j]
      s[j] = t
      ++i
      --j
    }
  }
}
