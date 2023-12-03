class Solution {
  fun isAcronym(words: List<String>, s: String): Boolean {
    val t = StringBuilder()
    for (w in words) {
      t.append(w.charAt(0))
    }
    return t.toString() == s
  }
}
