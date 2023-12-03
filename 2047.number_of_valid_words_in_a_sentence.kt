internal class Solution {
  fun countValidWords(sentence: String): Int {
    var ans = 0
    for (token in sentence.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      if (check(token)) {
        ++ans
      }
    }
    return ans
  }

  private fun check(token: String): Boolean {
    val n = token.length
    if (n == 0) {
      return false
    }
    var hyphen = false
    for (i in 0 until n) {
      val c = token[i]
      if (Character.isDigit(c) || i < n - 1 && (c == '!' || c == '.' || c == ',')) {
        return false
      }
      if (c == '-') {
        if (hyphen || i == 0 || i == n - 1 || !Character.isLetter(token[i - 1])
          || !Character.isLetter(token[i + 1])
        ) {
          return false
        }
        hyphen = true
      }
    }
    return true
  }
}
