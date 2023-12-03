class Solution {
  fun numberOfWays(s: String): Long {
    val n = s.length
    var cnt0 = 0
    for (c in s.toCharArray()) {
      if (c == '0') {
        ++cnt0
      }
    }
    val cnt1 = n - cnt0
    var ans: Long = 0
    var c0 = 0
    var c1 = 0
    for (c in s.toCharArray()) {
      if (c == '0') {
        ans += (c1 * (cnt1 - c1)).toLong()
        ++c0
      } else {
        ans += (c0 * (cnt0 - c0)).toLong()
        ++c1
      }
    }
    return ans
  }
}
