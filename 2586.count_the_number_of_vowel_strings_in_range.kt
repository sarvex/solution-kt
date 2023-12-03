class Solution {
  fun vowelStrings(words: Array<String>, left: Int, right: Int): Int {
    var ans = 0
    for (i in left..right) {
      val w = words[i]
      if (check(w[0]) && check(w[w.length - 1])) {
        ++ans
      }
    }
    return ans
  }

  private fun check(c: Char): Boolean {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
  }
}
