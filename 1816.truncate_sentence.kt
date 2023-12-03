class Solution {
  fun truncateSentence(s: String, k: Int): String {
    var k = k
    for (i in 0 until s.length) {
      if (s[i] == ' ' && --k == 0) {
        return s.substring(0, i)
      }
    }
    return s
  }
}
