internal class Solution {
  fun reverseOnlyLetters(s: String): String {
    val chars = s.toCharArray()
    var i = 0
    var j = s.length - 1
    while (i < j) {
      while (i < j && !Character.isLetter(chars[i])) {
        ++i
      }
      while (i < j && !Character.isLetter(chars[j])) {
        --j
      }
      if (i < j) {
        val t = chars[i]
        chars[i] = chars[j]
        chars[j] = t
        ++i
        --j
      }
    }
    return String(chars)
  }
}
