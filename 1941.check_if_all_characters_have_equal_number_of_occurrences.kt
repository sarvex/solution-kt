class Solution {
  fun areOccurrencesEqual(s: String): Boolean {
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - 'a'.code]
    }
    var x = 0
    for (v in cnt) {
      if (v > 0) {
        if (x == 0) {
          x = v
        } else if (x != v) {
          return false
        }
      }
    }
    return true
  }
}
