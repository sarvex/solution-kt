class Solution {
  fun isPrefixString(s: String, words: Array<String?>): Boolean {
    val t = StringBuilder()
    for (w in words) {
      t.append(w)
      if (s.length == t.length) {
        return s == t.toString()
      }
    }
    return false
  }
}
