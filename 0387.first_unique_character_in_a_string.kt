internal class Solution {
  fun firstUniqChar(s: String): Int {
    val cnt = IntArray(26)
    val n = s.length
    for (i in 0 until n) {
      ++cnt[s[i].code - 'a'.code]
    }
    for (i in 0 until n) {
      if (cnt[s[i].code - 'a'.code] == 1) {
        return i
      }
    }
    return -1
  }
}
