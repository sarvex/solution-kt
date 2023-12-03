internal class Solution {
  fun numSpecialEquivGroups(words: Array<String>): Int {
    val s: Set<String> = HashSet()
    for (word in words) {
      s.add(convert(word))
    }
    return s.size()
  }

  private fun convert(word: String): String {
    val a: List<Char> = ArrayList()
    val b: List<Char> = ArrayList()
    for (i in 0 until word.length) {
      val ch = word[i]
      if (i % 2 == 0) {
        a.add(ch)
      } else {
        b.add(ch)
      }
    }
    Collections.sort(a)
    Collections.sort(b)
    val sb = StringBuilder()
    for (c in a) {
      sb.append(c)
    }
    for (c in b) {
      sb.append(c)
    }
    return sb.toString()
  }
}
