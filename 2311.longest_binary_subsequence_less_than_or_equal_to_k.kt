class Solution {
  fun longestSubsequence(s: String, k: Int): Int {
    var ans = 0
    var v = 0
    for (i in s.length - 1 downTo 0) {
      if (s[i] == '0') {
        ++ans
      } else if (ans < 30 && v or (1 shl ans) <= k) {
        v = v or (1 shl ans)
        ++ans
      }
    }
    return ans
  }
}
