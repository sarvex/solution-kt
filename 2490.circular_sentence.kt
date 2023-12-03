class Solution {
  fun isCircularSentence(s: String): Boolean {
    val n = s.length
    if (s[0] != s[n - 1]) {
      return false
    }
    for (i in 1 until n) {
      if (s[i] == ' ' && s[i - 1] != s[i + 1]) {
        return false
      }
    }
    return true
  }
}
