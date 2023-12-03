internal class Solution {
  fun isValid(s: String): Boolean {
    if (s.length % 3 > 0) {
      return false
    }
    val t = StringBuilder()
    for (c in s.toCharArray()) {
      t.append(c)
      if (t.length >= 3 && "abc" == t.substring(t.length - 3)) {
        t.delete(t.length - 3, t.length)
      }
    }
    return t.isEmpty()
  }
}
