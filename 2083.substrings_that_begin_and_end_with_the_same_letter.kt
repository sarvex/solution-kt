internal class Solution {
  fun numberOfSubstrings(s: String): Long {
    val cnt = IntArray(26)
    var ans: Long = 0
    for (i in 0 until s.length) {
      val j = s[i].code - 'a'.code
      ++cnt[j]
      ans += cnt[j].toLong()
    }
    return ans
  }
}
