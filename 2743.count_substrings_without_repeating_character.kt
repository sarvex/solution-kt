class Solution {
  fun numberOfSpecialSubstrings(s: String): Int {
    val n = s.length
    var ans = 0
    val cnt = IntArray(26)
    var i = 0
    var j = 0
    while (i < n) {
      val k = s[i].code - 'a'.code
      ++cnt[k]
      while (cnt[k] > 1) {
        --cnt[s[j++].code - 'a'.code]
      }
      ans += i - j + 1
      ++i
    }
    return ans
  }
}
