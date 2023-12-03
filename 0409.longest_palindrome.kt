internal class Solution {
  fun longestPalindrome(s: String): Int {
    val cnt = IntArray(128)
    for (i in 0 until s.length) {
      ++cnt[s[i].code]
    }
    var ans = 0
    for (v in cnt) {
      ans += v - (v and 1)
      if (ans % 2 == 0 && v % 2 == 1) {
        ++ans
      }
    }
    return ans
  }
}
