class Solution {
  fun minSteps(s: String, t: String): Int {
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - 'a'.code]
    }
    var ans = 0
    for (i in 0 until t.length) {
      if (--cnt[t[i].code - 'a'.code] < 0) {
        ++ans
      }
    }
    return ans
  }
}
