class Solution {
  fun minimumSteps(s: String): Long {
    var ans: Long = 0
    var cnt = 0
    val n = s.length
    for (i in n - 1 downTo 0) {
      if (s[i] == '1') {
        ++cnt
        ans += (n - i - cnt).toLong()
      }
    }
    return ans
  }
}
