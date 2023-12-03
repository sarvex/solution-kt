class Solution {
  fun checkStrings(s1: String, s2: String): Boolean {
    val cnt = Array(2) { IntArray(26) }
    for (i in 0 until s1.length) {
      ++cnt[i and 1][s1[i].code - 'a'.code]
      --cnt[i and 1][s2[i].code - 'a'.code]
    }
    for (i in 0..25) {
      if (cnt[0][i] != 0 || cnt[1][i] != 0) {
        return false
      }
    }
    return true
  }
}
