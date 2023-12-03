class Solution {
  fun discountPrices(sentence: String, discount: Int): String {
    val words = sentence.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (i in words.indices) {
      if (check(words[i])) {
        val t = words[i].substring(1).toLong() * (1 - discount / 100.0)
        words[i] = String.format("$%.2f", t)
      }
    }
    return java.lang.String.join(" ", *words)
  }

  private fun check(s: String): Boolean {
    if (s[0] != '$' || s.length == 1) {
      return false
    }
    for (i in 1 until s.length) {
      if (!Character.isDigit(s[i])) {
        return false
      }
    }
    return true
  }
}
