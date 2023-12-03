class Solution {
  fun countGoodSubstrings(s: String): Int {
    var count = 0
    val n = s.length
    for (i in 0 until n - 2) {
      val a = s[i]
      val b = s[i + 1]
      val c = s[i + 2]
      if (a != b && a != c && b != c) {
        ++count
      }
    }
    return count
  }
}
