internal class Solution {
  fun countVowelSubstrings(word: String): Int {
    val n = word.length
    var ans = 0
    for (i in 0 until n) {
      val t: Set<Char> = HashSet()
      for (j in i until n) {
        val c = word[j]
        if (!isVowel(c)) {
          break
        }
        t.add(c)
        if (t.size() === 5) {
          ++ans
        }
      }
    }
    return ans
  }

  private fun isVowel(c: Char): Boolean {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
  }
}
