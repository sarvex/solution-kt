class Solution {
  fun countHomogenous(s: String): Int {
    val n = s.length
    var ans: Long = 0
    var i = 0
    var j = 0
    while (i < n) {
      j = i
      while (j < n && s[j] == s[i]) {
        ++j
      }
      val cnt = j - i
      ans += (1 + cnt).toLong() * cnt / 2
      ans %= Solution.Companion.MOD.toLong()
      i = j
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
