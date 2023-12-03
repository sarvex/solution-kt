internal class Solution {
  fun findTheDifference(s: String, t: String): Char {
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - 'a'.code]
    }
    var i = 0
    while (true) {
      if (--cnt[t[i].code - 'a'.code] < 0) {
        return t[i]
      }
      ++i
    }
  }
}
