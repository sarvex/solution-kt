internal class Solution {
  fun minWindow(s: String, t: String): String {
    val need = IntArray(128)
    val window = IntArray(128)
    val m = s.length
    val n = t.length
    for (i in 0 until n) {
      ++need[t[i].code]
    }
    var cnt = 0
    var j = 0
    var k = -1
    var mi = 1 shl 30
    for (i in 0 until m) {
      ++window[s[i].code]
      if (need[s[i].code] >= window[s[i].code]) {
        ++cnt
      }
      while (cnt == n) {
        if (i - j + 1 < mi) {
          mi = i - j + 1
          k = j
        }
        if (need[s[j].code] >= window[s[j].code]) {
          --cnt
        }
        --window[s[j++].code]
      }
    }
    return if (k < 0) "" else s.substring(k, k + mi)
  }
}
