class Solution {
  fun countConsistentStrings(allowed: String, words: Array<String>): Int {
    val s = BooleanArray(26)
    for (c in allowed.toCharArray()) {
      s[c.code - 'a'.code] = true
    }
    var ans = 0
    for (w in words) {
      if (check(w, s)) {
        ++ans
      }
    }
    return ans
  }

  private fun check(w: String, s: BooleanArray): Boolean {
    for (i in 0 until w.length) {
      if (!s[w[i].code - 'a'.code]) {
        return false
      }
    }
    return true
  }
}
