internal class Solution {
  fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
      return false
    }
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - 'a'.code]
      --cnt[t[i].code - 'a'.code]
    }
    for (i in 0..25) {
      if (cnt[i] != 0) {
        return false
      }
    }
    return true
  }
}
