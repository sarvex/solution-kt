internal class Solution {
  fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
    val ans: List<String> = ArrayList()
    for (word in words) {
      if (match(word, pattern)) {
        ans.add(word)
      }
    }
    return ans
  }

  private fun match(s: String, t: String): Boolean {
    val m1 = IntArray(128)
    val m2 = IntArray(128)
    for (i in 0 until s.length) {
      val c1 = s[i]
      val c2 = t[i]
      if (m1[c1.code] != m2[c2.code]) {
        return false
      }
      m1[c1.code] = i + 1
      m2[c2.code] = i + 1
    }
    return true
  }
}
