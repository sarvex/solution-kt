class Solution {
  fun finalString(s: String): String {
    val t = StringBuilder()
    for (c in s.toCharArray()) {
      if (c == 'i') {
        t.reverse()
      } else {
        t.append(c)
      }
    }
    return t.toString()
  }
}
