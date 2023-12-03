class Solution {
  fun canConvertString(s: String, t: String, k: Int): Boolean {
    if (s.length != t.length) {
      return false
    }
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      val x = (t[i].code - s[i].code + 26) % 26
      ++cnt[x]
    }
    for (i in 1..25) {
      if (i + 26 * (cnt[i] - 1) > k) {
        return false
      }
    }
    return true
  }
}
