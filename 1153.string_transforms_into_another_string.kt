internal class Solution {
  fun canConvert(str1: String, str2: String): Boolean {
    if (str1 == str2) {
      return true
    }
    var m = 0
    val cnt = IntArray(26)
    val n = str1.length
    for (i in 0 until n) {
      if (++cnt[str2[i].code - 'a'.code] == 1) {
        ++m
      }
    }
    if (m == 26) {
      return false
    }
    val d = IntArray(26)
    for (i in 0 until n) {
      val a = str1[i].code - 'a'.code
      val b = str2[i].code - 'a'.code
      if (d[a] == 0) {
        d[a] = b + 1
      } else if (d[a] != b + 1) {
        return false
      }
    }
    return true
  }
}
