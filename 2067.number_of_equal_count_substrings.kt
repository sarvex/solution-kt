internal class Solution {
  fun equalCountSubstrings(s: String, count: Int): Int {
    var ans = 0
    val n = s.length
    var x = 1
    while (x < 27 && count * x <= n) {
      val m = count * x
      val cnt = IntArray(26)
      var y = 0
      for (i in 0 until n) {
        val a = s[i].code - 'a'.code
        ++cnt[a]
        if (cnt[a] == count) {
          ++y
        }
        if (cnt[a] == count + 1) {
          --y
        }
        val j = i - m
        if (j >= 0) {
          val b = s[j].code - 'a'.code
          --cnt[b]
          if (cnt[b] == count) {
            ++y
          }
          if (cnt[b] == count - 1) {
            --y
          }
        }
        if (x == y) {
          ++ans
        }
      }
      ++x
    }
    return ans
  }
}
