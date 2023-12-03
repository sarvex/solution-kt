internal class Solution {
  fun numKLenSubstrNoRepeats(s: String, k: Int): Int {
    val n = s.length
    if (k > n || k > 26) {
      return 0
    }
    val cnt = IntArray(128)
    var ans = 0
    var i = 0
    var j = 0
    while (i < n) {
      ++cnt[s[i].code]
      while (cnt[s[i].code] > 1 || i - j + 1 > k) {
        cnt[s[j++].code]--
      }
      ans += if (i - j + 1 == k) 1 else 0
      ++i
    }
    return ans
  }
}
