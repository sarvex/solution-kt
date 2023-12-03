class Solution {
  fun numSub(s: String): Int {
    val mod = 1e9.toInt() + 7
    var ans = 0
    var cnt = 0
    for (i in 0 until s.length) {
      cnt = if (s[i] == '1') cnt + 1 else 0
      ans = (ans + cnt) % mod
    }
    return ans
  }
}
